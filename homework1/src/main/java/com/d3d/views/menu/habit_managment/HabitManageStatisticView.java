package com.d3d.views.menu.habit_managment;

import java.util.List;

import com.d3d.controllers.habit_manage.HabitManageController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitManageStatisticView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список привычек:\n");
        List<Habit> list = HabitManageController.habitList(user);
        Out.printListHabit(list);
        Out.print("Выберите из списка номер привычки,\n" +
                "статистику которой хотите посмотреть");
        try {
            int posistion = InputOption.in() - 1 ;
            if ((posistion >= 0) && (posistion < list.size())) {
                Out.print("Выберите период\n" +
                        "1 - День\n" + 
                        "2 - Неделя\n" + 
                        "3 - Месяц");
                int periodCode = InputOption.in();
                if((periodCode > 0) && (periodCode < 4)){
                    List<HabitEntry> listHabit = HabitManageController.habitStatistic(periodCode, user, (Habit)list.toArray()[posistion]);
                    Out.printListHabitEntry(listHabit);
                    SuccesOut.show();
                }
                else{
                    throw new Exception("Неверно введен период!");
                }
            } else {
                throw new Exception("Неверно введен номер привычки!");
            }

        } catch (Exception ex) {
            ErrorOut.show(ex);
        }
        Input.skip();
        HabitManageController.menu(user);

    }
}
