package com.d3d.controllers.habit_edit;

import java.util.Date;
import java.util.List;

import com.d3d.controllers.MainController;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.habit.HabitManage;
import com.d3d.views.menu.habit_edit.HabitEditCreateView;
import com.d3d.views.menu.habit_edit.HabitEditDeleteView;
import com.d3d.views.menu.habit_edit.HabitEditReadView;
import com.d3d.views.menu.habit_edit.HabitEditUpdateView;
import com.d3d.views.menu.habit_edit.HabitEditView;

public class HabitEditController {
    public static void menu(User user){
        HabitEditView.show(user);
    }
    public static void create(User user){
        HabitEditCreateView.show(user);
    }
    public static void read(User user){
        HabitEditReadView.show(user);
    }
    public static void update(User user){
        HabitEditUpdateView.show(user);
    }
    public static void delete(User user){
        HabitEditDeleteView.show(user);
    }
    public static void back(User user){
        MainController.menu(user);
    }
    public static void add(Habit habit, User user) throws Exception{
        HabitManage.add(habit, user);
    }
    public static List<Habit> getHabitList(User user, Date dateFilter, int statusFilterCode ){
        return HabitManage.read(user, dateFilter, statusFilterCode);
    }
    public static void updateName(User user, Habit habit, String newName){
        HabitManage.updateName(user, habit, newName);
    }
    public static void updateDescription(User user, Habit habit, String newDescription){
        HabitManage.updateDescription(user, habit, newDescription);
    }
    public static void updateStatus(User user, Habit habit, boolean newStatus){
        HabitManage.updateStatus(user, habit, newStatus);
    }
    public static void deleteHabit(User user, Habit habit){
        HabitManage.delete(user, habit);
    }
    public static void updateRegularity(User user, Habit habit, int newRegularity){
        HabitManage.updateRegularity(user,habit,newRegularity);
    }
}
