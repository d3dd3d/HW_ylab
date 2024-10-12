package com.d3d.controllers;

import com.d3d.controllers.auth.AuthController;

public class AppStart {
    public void start(){

        // DateWatcher dateWatcher = new DateWatcher();
        // dateWatcher.watch();
    
        AuthController.startAuth();
    }
    
}
