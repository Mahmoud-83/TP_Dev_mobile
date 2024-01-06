package com.example.mahmoud_amar_tp2.controller;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mahmoud_amar_tp2.model.User;

public class LoginController {

    private static LoginController instance =null;
    private static User user;
    private static final String BD = "mySharedPrefs";
    private LoginController(){super();}

    public void CreateUser(String login, String pass,Context context){
        // Creation du user
        user = new User(login,pass);
        // persistance des donnes de user
        SharedPreferences sharedPreferences = context.getSharedPreferences(BD,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LOGIN",login);
        editor.putString("PASS", pass);
        editor.apply();
    }

    public static void RecapUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(BD,MODE_PRIVATE);
        String login = sharedPreferences.getString("LOGIN","");
        String pass = sharedPreferences.getString("PASS","");
        user= new User(login,pass);
    }


    public String getLogin() {
        return user.getLogin();
    }

    public String getPass() {
        return user.getPass();
    }
    public static LoginController getInstance(Context context){
        if(instance == null)
            return instance = new LoginController();
        RecapUser(context);
        return instance;
    }


}
