package org.tk2100.bank.unsecure;

/**
 * Created by arcuri82 on 21-Mar-18.
 */
public class UserDto {

    public final String userId;

    public final int balance;

    public UserDto(String userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }
}
