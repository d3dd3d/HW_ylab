package com.d3d.views.menu.habit_managment;

import com.d3d.controllers.habit_manage.HabitManageController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class HabitManageView {
    public static void show(User user){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Отслеживание выполнения привычек\n" + 
                    "Введите цифру для выбора варианта\n" +
                    "1 - Отметить привычку выполненной\n" +
                    "2 - История выполнения привычек\n" +
                    "3 - Статистика\n" +
                    "0 - Назад");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        isFinish = true;
                        HabitManageController.complete(user);
                        break;
                    }
                    case 2:{
                        isFinish = true;
                        HabitManageController.history(user);
                        break;
                    }
                    case 3:{
                        isFinish = true;
                        HabitManageController.statistic(user);
                        break;
                    }
                    case 0:{
                        isFinish = true;
                        HabitManageController.back(user);
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
