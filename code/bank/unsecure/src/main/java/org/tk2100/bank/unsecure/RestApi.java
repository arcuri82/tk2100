package org.tk2100.bank.unsecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tk2100.bank.unsecure.db.User;
import org.tk2100.bank.unsecure.db.UserService;

/**
 * Created by arcuri82 on 16-Mar-18.
 */
@RestController
@RequestMapping(path = "/api")
@Scope("session")
public class RestApi {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;


    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity doLogin(
            @ModelAttribute(value = "userId") String userId,
            @ModelAttribute(value = "password") String password
    ) {
        boolean valid = loginService.login(userId, password);

        return ResponseEntity.status(valid ? 200 : 400).build();
    }

    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity doSignup(
            @ModelAttribute(value = "userId") String userId,
            @ModelAttribute(value = "password") String password
    ) {
        boolean valid = loginService.signup(userId, password);

        return ResponseEntity.status(valid ? 200 : 400).build();
    }

    @PostMapping(path = "/logout")
    public void doLogout(){
        loginService.logout();
    }


    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity doTransfer(
            @ModelAttribute(value = "to") String to,
            @ModelAttribute(value = "amount") int amount
    ){

        String userId = loginService.getLoggedInAs();
        if(userId == null){
            return ResponseEntity.status(401).build();
        }

        boolean success = userService.transferMoney(userId, to, amount);

        return ResponseEntity.status(success ? 200 : 400).build();
    }

    @GetMapping(path = "/user")
    public ResponseEntity<UserDto> getUser(){

        String userId = loginService.getLoggedInAs();

        if(userId == null){
            return ResponseEntity.status(401).build();
        }

        User user = userService.getUser(userId);
        UserDto dto = new UserDto(user.getUserId(), user.getBalance());

        return ResponseEntity.status(200).body(dto);
    }
}
