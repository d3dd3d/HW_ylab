package com.d3d.controllers;

import com.d3d.controllers.admin.AdminController;
import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.controllers.habit_manage.HabitManageController;
import com.d3d.controllers.user_edit.UserController;
import com.d3d.domain.model.User;
import com.d3d.views.menu.MainView;
import com.d3d.views.menu.statistics.StatisticView;

public class MainController {
    private static User currentUser;

    public static void menu(User user){
        if(currentUser==null){
            currentUser = user;
        }
        MainView.show(currentUser);
    }

    public static void habitEdit(){
        HabitEditController.menu(currentUser);
    }
    public static void habitManage(){
        HabitManageController.menu(currentUser);
    }
    public static void statistics(){
        StatisticView.show(currentUser);
    }
    public static void userEdit(){
        UserController.menu(currentUser);
    }
    public static void admin(){
        AdminController.menu(currentUser);
    }
}
