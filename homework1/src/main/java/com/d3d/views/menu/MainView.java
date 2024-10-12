package com.d3d.views.menu;

import com.d3d.controllers.MainController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class MainView {
    public static void show(User user){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Добро пожаловать в главное меню\n" +
                    "Введите цифру для выбора варианта\n" +
                    "1 - Редактирование профиля\n" +
                    "2 - Управление привычками\n" +
                    "3 - Отслеживание выполнения привычек\n" +
                    "4 - Статистика и аналитика\n" +
                    (user.isAdmin() ? "5 - Администрирование\n" : "") +
                    "0 - Выход");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        isFinish = true;
                        MainController.userEdit();
                        break;
                    }
                    case 2:{
                        isFinish = true;
                        MainController.habitEdit();
                        break;
                    }
                    case 3:{
                        isFinish = true;
                        MainController.habitManage();
                        break;
                    }
                    case 4:{
                        isFinish = true;
                        MainController.statistics();
                        break;
                    }
                    case 0:{
                        isFinish = true;
                        break;
                    }
                    case 5:{
                        if(user.isAdmin()){
                            isFinish = true;
                            MainController.admin();
                            break;
                        }
                    }
                    default:{
                        if(user.isAdmin())
                            ErrorOut.show(new Exception("Выберите из вариантов 0-5!"));
                        else
                            ErrorOut.show(new Exception("Выберите из вариантов 0-4!"));
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
