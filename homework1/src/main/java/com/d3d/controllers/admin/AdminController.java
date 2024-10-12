package com.d3d.controllers.admin;

import java.util.List;

import com.d3d.domain.model.User;
import com.d3d.domain.use_case.admin.AdminListUser;
import com.d3d.domain.use_case.admin.BlockUser;
import com.d3d.views.menu.admin.AdminBlockView;
import com.d3d.views.menu.admin.AdminVIew;

public class AdminController {
    public static void menu(User user){
        AdminVIew.show(user);
    }
    public static void block(User user){
        AdminBlockView.show(user);
    }
    public static List<User> userList(User user){
        return AdminListUser.getList();
    }
    public static void blockUser(User user) throws Exception{
        BlockUser.block(user);
    }
}
