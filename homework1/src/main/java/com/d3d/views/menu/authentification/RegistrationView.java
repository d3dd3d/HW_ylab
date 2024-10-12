package com.d3d.views.menu.authentification;

import com.d3d.controllers.auth.AuthController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputUser;
import com.d3d.domain.model.User;
import com.d3d.domain.model.UserList;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class RegistrationView {
    public static void show(UserList userList){
        Out.clear();
        Out.print("Пожалуйста введите в одну строчку\n"+
                "через пробел имя, email и пароль");
        try{
            User user = InputUser.in();
            if(!AuthController.add(user)){
                throw new Exception("Неправильный email!");
            }
            SuccesOut.show();
        }
        catch(Exception ex){
            ErrorOut.show(ex);
            
        }
        Input.skip();
        AuthController.startAuth();
        
    }
}
