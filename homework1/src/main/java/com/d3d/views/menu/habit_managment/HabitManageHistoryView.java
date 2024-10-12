package com.d3d.views.menu.habit_managment;

import java.util.List;

import com.d3d.controllers.habit_manage.HabitManageController;
import com.d3d.domain.in.Input;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitManageHistoryView {
public static void show(User user) {
        Out.clear();
        Out.print("История выполнения привычек:\n");
        List<HabitEntry> list = HabitManageController.habitHistoryList(user);
        Out.printListHabitEntry(list);
        SuccesOut.show();
        Input.skip();
        HabitManageController.menu(user);

    }
}
