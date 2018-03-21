package org.tk2100.bank.unsecure.db;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @NotBlank
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BALANCE")
    private int balance;

    public User(){}


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
