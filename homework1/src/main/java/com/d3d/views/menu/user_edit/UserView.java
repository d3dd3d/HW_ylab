package com.d3d.views.menu.user_edit;

import com.d3d.controllers.user_edit.UserController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class UserView {
    public static void show(User user){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Редактирование профиля\n" + 
                    "Ваш профиль:\n" +
                    Out.printUser(user) + "\n" +
                    "Введите цифру для выбора варианта\n" +
                    "1 - Редактирование профиля\n" +
                    "2 - Удаление профиля\n" +
                    "0 - Назад");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        isFinish = true;
                        UserController.edit(user);
                        break;
                    }
                    case 2:{
                        Out.print("Вы действительно хотите удалить профиль?\n" +
                            "1 - Да\n" +
                            "2 - Нет");
                        int deleteOption = InputOption.in();
                        switch (deleteOption) {
                            case 1:{
                                isFinish = true;
                                UserController.delete(user);
                                break;
                            }
                            case 2:{
                                break;
                            }
                            default:{
                                ErrorOut.show(new Exception("Выберите из вариантов 0-2!"));
                                break;
                            }
                        }
                        break;
                    }
                    case 0:{
                        isFinish = true;
                        UserController.back(user);
                        break;
                    }
                    default:{
                        ErrorOut.show(new Exception("Выберите из вариантов 0-2!"));
                        break;
                    }
                }
            }
            catch(Exception ex){
                ErrorOut.show(ex);
            }
        }
    }

}
