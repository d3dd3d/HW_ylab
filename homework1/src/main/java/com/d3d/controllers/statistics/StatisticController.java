package com.d3d.controllers.statistics;

import java.util.List;

import com.d3d.controllers.MainController;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.habit.HabitManage;
import com.d3d.domain.use_case.statistic.HabitStats;
import com.d3d.views.menu.statistics.StatisticPercentView;
import com.d3d.views.menu.statistics.StatisticView;

public class StatisticController {
    public static void menu(User user){
        StatisticView.show(user);
    }
    public static void percent(User user){
        StatisticPercentView.show(user);
    }
    public static void back(User user){
        MainController.menu(user);
    }
    public static int streak(User user){
        return HabitStats.habitSeries(user);
    }
    public static List<Habit> habitList(User user){
        return HabitManage.read(user, null, 2);
    }
    public static int percentComplete(int periodCode, User user) throws Exception{
        return HabitStats.habitCompletionPercent(periodCode, user);
    }
    
}
