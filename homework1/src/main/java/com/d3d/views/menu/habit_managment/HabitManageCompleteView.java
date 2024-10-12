package com.d3d.views.menu.habit_managment;

import java.util.List;

import com.d3d.controllers.habit_manage.HabitManageController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitManageCompleteView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список привычек:\n");
        List<HabitEntry> list = HabitManageController.habitTodayList(user);
        Out.printListHabitEntry(list);
        Out.print("Выберите из списка номер привычки,\n" +
                "которую хотите выполнить");
        try {
            int posistion = InputOption.in() - 1;
            if ((posistion >= 0) && (posistion < list.size())) {
                HabitManageController.completeHabit(user, (HabitEntry)list.toArray()[posistion]);
                SuccesOut.show();
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
