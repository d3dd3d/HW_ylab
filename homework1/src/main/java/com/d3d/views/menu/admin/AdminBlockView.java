package com.d3d.views.menu.admin;

import java.util.List;

import com.d3d.controllers.admin.AdminController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class AdminBlockView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список пользователей:\n");
        List<User> users = AdminController.userList(user);
        Out.printUsers(users);
        Out.print("Выберите из списка номер пользователя,\n" +
                "которого хотите заблокировать");
        try {
            int posistion = InputOption.in() - 1;
            if ((posistion >= 0) && (posistion < users.size())) {
                AdminController.blockUser(users.get(posistion));
                SuccesOut.show();
            } else {
                throw new Exception("Неверно введен номер пользователя!");
            }

        } catch (Exception ex) {
            ErrorOut.show(ex);
        }
        Input.skip();
        AdminController.menu(user);

    }
}
