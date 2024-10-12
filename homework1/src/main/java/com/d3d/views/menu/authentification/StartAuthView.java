package com.d3d.views.menu.authentification;

import com.d3d.controllers.auth.AuthController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class StartAuthView {
    public static void show(){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Приложение для отслеживания привычек\n"+
                    "Введите цифру для выбора варианта\n"+
                    "1 - Вход\n"+
                    "2 - Регистрация\n"+
                    "3 - Сброс пароля (не реализовано)\n"+
                    "0 - Выход");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        isFinish = true;
                        AuthController.auth();
                        break;
                    }
                    case 2:{
                        isFinish = true;
                        AuthController.registration();
                        break;
                    }
                    case 3:{
                        ErrorOut.show(new Exception("Данная функция пока не реализована!"));
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
    }
}
