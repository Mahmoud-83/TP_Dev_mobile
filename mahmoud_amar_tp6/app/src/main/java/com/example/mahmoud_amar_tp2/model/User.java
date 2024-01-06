package com.example.mahmoud_amar_tp2.model;

public class User {
    private String login;
    private String pass;

    public User(String login,String pass){
        this.login=login;
        this.pass=pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

}
