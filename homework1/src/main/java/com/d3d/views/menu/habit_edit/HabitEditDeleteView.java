package com.d3d.views.menu.habit_edit;

import java.util.List;

import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitEditDeleteView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список привычек:\n");
        List<Habit> list = HabitEditController.getHabitList(user, null, 0);
        Out.printListHabit(list);
        Out.print("Выберите из списка номер привычки,\n" +
                "которую хотите удалить");
        try {
            int posistion = InputOption.in() - 1;
            if ((posistion >= 0) && (posistion < list.size())) {
                HabitEditController.deleteHabit(user, (Habit)list.toArray()[posistion]);
                SuccesOut.show();
            } else {
                throw new Exception("Неверно введен номер привычки!");
            }

        } catch (Exception ex) {
            ErrorOut.show(ex);
        }
        Input.skip();
        HabitEditController.menu(user);

    }
}
