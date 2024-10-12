package com.d3d;

import com.d3d.controllers.AppStart;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.user.UserAuth;

public class Main {
    public static void main(String[] args) throws Exception {
        AppStart app = new AppStart(); 
        UserAuth us = new UserAuth();
        us.registration(new User("admin","1","admin@gmail.com",true));
        app.start();
       
    }
}