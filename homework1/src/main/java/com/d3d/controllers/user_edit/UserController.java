package com.d3d.controllers.user_edit;

import com.d3d.controllers.MainController;
import com.d3d.controllers.auth.AuthController;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.user.UserAuth;
import com.d3d.domain.use_case.user.UserDelete;
import com.d3d.domain.use_case.user.UserUpdate;
import com.d3d.views.menu.user_edit.UserEditView;
import com.d3d.views.menu.user_edit.UserView;

public class UserController {
    public static void menu(User currentUser){
        UserView.show(currentUser);
    }
    public static void edit(User currentUser){
        UserEditView.show(currentUser);
    }
    public static void delete(User currentUser){
        UserDelete.delete(currentUser);
        AuthController.startAuth();
    }
    public static void back(User currentUser){
        MainController.menu(currentUser);
    }
    public static void saveName(String name, User currentUser){
        UserUpdate.nameUpdate(currentUser, name);
    }
    public static void saveEmail(String email, User currentUser){
        UserUpdate.emailUpdate(currentUser, email);
    }
    public static boolean checkPassword(String oldPassword, User currentUser) throws Exception{
        return UserAuth.passwordCheck(oldPassword, currentUser.getEmail());
    }
    public static void savePassword(String newPassword, User currentUser){
        UserUpdate.passwordUpdate(currentUser, newPassword);
    }
    
}
