package com.d3d.views.menu.authentification;

import com.d3d.controllers.auth.AuthController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputUser;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;


public class AuthView {
    public static void show(){
        Out.clear();
        Out.print("Пожалуйста введите в одну строчку\n"+
                "через пробел email и пароль");
        try{
            User user = InputUser.authIn();
            user = AuthController.logIn(user);
            SuccesOut.show();
            Input.skip();
            AuthController.menu(user);
        }
        catch(Exception ex){
            ErrorOut.show(ex);
            Input.skip();
            AuthController.startAuth();
        }
        
        
    }
}
