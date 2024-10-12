package com.d3d.views.menu.habit_edit;

import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class HabitEditView {
    public static void show(User user){
        boolean isFinish = false;
        while(!isFinish){
            Out.clear();
            Out.print("Редактирование привычек\n" + 
                    "Введите цифру для выбора варианта\n" +
                    "1 - Создать привычку\n" +
                    "2 - Список привычек\n" +
                    "3 - Изменить привычку\n" +
                    "4 - Удалить привычку\n" +
                    "0 - Назад");
            try{
                int option = InputOption.in();
                switch (option) {
                    case 1:{
                        isFinish = true;
                        HabitEditController.create(user);
                        break;
                    }
                    case 2:{
                        isFinish = true;
                        HabitEditController.read(user);
                        break;
                    }
                    case 3:{
                        isFinish = true;
                        HabitEditController.update(user);
                        break;
                    }
                    case 4:{
                        isFinish = true;
                        HabitEditController.delete(user);
                        break;
                    }
                    case 0:{
                        isFinish = true;
                        HabitEditController.back(user);
                        break;
                    }
                    default:{
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
