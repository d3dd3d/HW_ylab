package com.d3d.views.menu.habit_edit;

import java.util.Date;
import java.util.List;

import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.domain.in.InputDate;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class HabitEditReadView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список привычек:\n");
        List<Habit> list = HabitEditController.getHabitList(user, null, 0);
        Out.printListHabit(list);
        boolean isFinish = false;
        while (!isFinish) {
            Out.print("Выберите один из вариантов\n" +
                    "1 - Фильтр по дате\n" +
                    "2 - Фильтр по статусу\n" +
                    "0 - назад");
            try {
                int option = InputOption.in();
                switch (option) {
                    case 1: {
                        Out.clear();
                        Out.print("Пожалуйста введите в одну строчку\n"+
                                "дату в формате день.месяц.год");
                        Date dateFilter = InputDate.in();
                        Out.print("Список привычек:\n");
                        list = HabitEditController.getHabitList(user, dateFilter, 0);
                        Out.printListHabit(list);
                        break;
                    }
                    case 2: {
                        Out.clear();
                        Out.print("Пожалуйста выберите один из вариантов\n"+
                                "1 - Активен\n" +
                                "2 - Неактивен");
                        int statusFilterCode = InputOption.in();
                        if((statusFilterCode==1)||(statusFilterCode==2)){
                            Out.print("Список привычек:\n");
                            list = HabitEditController.getHabitList(user, null, statusFilterCode);
                            Out.printListHabit(list);
                        }
                        else{
                            throw new Exception("Неверно выбран вариант");
                        }
                        break;
                    }
                    case 0: {
                        isFinish = true;
                        HabitEditController.menu(user);
                        break;
                    }
                    default: {
                        ErrorOut.show(new Exception("Выберите из вариантов 0-2!"));
                        break;
                    }
                }
            } catch (Exception ex) {
                ErrorOut.show(ex);
            }
        }

    }
}
