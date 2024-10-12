package com.d3d.views.menu.user_edit;

import com.d3d.controllers.user_edit.UserController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.in.InputParam;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class UserEditView {
    public static void show(User user){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Введите цифру для выбора варианта\n" +
                    "1 - Редактирование имени\n" +
                    "2 - Редактирование email\n" +
                    "3 - Редактирование пароля\n" +
                    "0 - Назад");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        Out.print("Введите новое имя");
                        String newName = InputParam.in();
                        UserController.saveName(newName, user);
                        SuccesOut.show();
                        isFinish = true;
                        break;
                    }
                    case 2:{
                        Out.print("Введите новый email");
                        String newEmail = InputParam.in();
                        UserController.saveEmail(newEmail,user);
                        SuccesOut.show();
                        isFinish = true;
                        break;
                    }
                    case 3:{
                        Out.print("Введите старый пароль");
                        String oldPassword = InputParam.in();
                        UserController.checkPassword(oldPassword,user);
                        Out.print("Введите старый пароль");
                        String newPassword = InputParam.in();
                        UserController.savePassword(newPassword, user);
                        SuccesOut.show();
                        isFinish = true;
                        break;
                    }
                    case 0:{
                        isFinish = true;
                        break;
                    }
                    default:{
                        ErrorOut.show(new Exception("Выберите из вариантов 0-3!"));
                        break;
                    }
                }
            }
            catch(Exception ex){
                ErrorOut.show(ex);
            }
        }
        Input.skip();
        UserController.menu(user);
    }

}
