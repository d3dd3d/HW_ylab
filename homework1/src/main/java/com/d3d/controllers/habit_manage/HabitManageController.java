package com.d3d.controllers.habit_manage;

import java.util.List;

import com.d3d.controllers.MainController;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.habit.HabitManage;
import com.d3d.domain.use_case.habit.HabitWatch;
import com.d3d.views.menu.habit_managment.HabitManageCompleteView;
import com.d3d.views.menu.habit_managment.HabitManageHistoryView;
import com.d3d.views.menu.habit_managment.HabitManageStatisticView;
import com.d3d.views.menu.habit_managment.HabitManageView;

public class HabitManageController {
    public static void menu(User user){
        HabitManageView.show(user);
    }
    public static void complete(User user){
        HabitManageCompleteView.show(user);
    }
    public static void history(User user){
        HabitManageHistoryView.show(user);
    }
    public static void statistic(User user){
        HabitManageStatisticView.show(user);
    }
    public static void back(User user){
        MainController.menu(user);
    }
    public static List<HabitEntry> habitHistoryList(User user){
        return HabitWatch.historyList(user);
    }
    public static List<HabitEntry> habitTodayList(User user){
        return HabitWatch.habitTodayList(user);
    }
    public static void completeHabit(User user, HabitEntry habit) throws Exception{
        HabitWatch.habitDone(user, habit);
    }
    public static List<Habit> habitList(User user){
        return HabitManage.read(user, null, 0);
    }
    public static List<HabitEntry> habitStatistic(int periodCode, User user, Habit habit){
        return HabitWatch.statistics(periodCode, user, habit);    
    }
}
