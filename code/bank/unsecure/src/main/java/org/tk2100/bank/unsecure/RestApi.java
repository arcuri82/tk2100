package org.tk2100.bank.unsecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tk2100.bank.unsecure.db.UserService;

/**
 * Created by arcuri82 on 16-Mar-18.
 */
@RestController
@RequestMapping(path = "/api")
public class RestApi {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;


    @PostMapping(path = "/login")
    public ResponseEntity doLogin(
            @ModelAttribute(value = "userId") String userId,
            @ModelAttribute(value = "password") String password
    ) {
        boolean valid = loginService.login(userId, password);

        return ResponseEntity.status(valid ? 200 : 400).build();
    }

    @PostMapping(path = "/logout")
    public void doLogout(){
        loginService.logout();
    }

    @GetMapping(path = "/balance", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> getBalance(){

        String userId = loginService.getLoggedInAs();
        if(userId == null){
            return ResponseEntity.status(401).build();
        }

        int balance =  userService.getUser(userId).getBalance();
        return ResponseEntity.ok(balance);
    }

    @PostMapping(path = "/transfer")
    public ResponseEntity doTransfer(
            @ModelAttribute(value = "from") String from,
            @ModelAttribute(value = "to") String to,
            @ModelAttribute(value = "amount") int amount
    ){

        String userId = loginService.getLoggedInAs();
        if(userId == null){
            return ResponseEntity.status(401).build();
        }
        if(!userId.equals(from)){
            return ResponseEntity.status(403).build();
        }

        boolean success = userService.transferMoney(from, to, amount);

        return ResponseEntity.status(success ? 200 : 400).build();
    }

    @GetMapping(path = "/userId")
    public ResponseEntity<String> getUser(){

        String userId = loginService.getLoggedInAs();

        return ResponseEntity.status(userId != null ? 200 : 401).body(userId);
    }
}
