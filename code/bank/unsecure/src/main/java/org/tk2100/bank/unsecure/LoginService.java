package org.tk2100.bank.unsecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.tk2100.bank.unsecure.db.UserService;

/**
 * Created by arcuri82 on 16-Mar-18.
 */
@Service
@Scope("session")
public class LoginService {

    @Autowired
    private UserService userService;

    private String loggedInAs;

    public boolean isLoggedIn(){
        return loggedInAs != null;
    }


    public boolean login(String userId, String password){

        boolean valid = userService.canLogin(userId, password);
        if(! valid){
            return false;
        }

        loggedInAs = userId;

        return true;
    }

    public void logout(){
        loggedInAs = null;
    }

    public String getLoggedInAs() {
        return loggedInAs;
    }
}
