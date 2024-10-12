package com.d3d.controllers.auth;

import com.d3d.controllers.MainController;
import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.email.EmailValidator;
import com.d3d.domain.use_case.user.UserAuth;
import com.d3d.views.menu.authentification.AuthView;
import com.d3d.views.menu.authentification.RegistrationView;
import com.d3d.views.menu.authentification.StartAuthView;

public class AuthController {
    public static void startAuth(){
        StartAuthView.show();
    }
    public static void registration(){
        RegistrationView.show(Data.getUserList());
    }
    public static void auth(){
        AuthView.show();
    }
    public static boolean add(User user) throws Exception{
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(user.getEmail()))
            return false;
        try{
            UserAuth userAuth = new UserAuth();
            userAuth.registration(user);
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return true;
    }

    public static User logIn(User user) throws Exception{
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(user.getEmail()))
            throw new Exception("Неверно введен email!");
        try{
            UserAuth userAuth = new UserAuth();
            userAuth.auth(user.getPassword(), user.getEmail());
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return Data.getUserList().find(user.getEmail());
    }

    public static void menu(User user){
        MainController.menu(user);
    }
}
