package com.d3d.views.menu.admin;

import com.d3d.controllers.admin.AdminController;
import com.d3d.controllers.statistics.StatisticController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class AdminVIew {
    public static void show(User user) {
        boolean isFinish = false;
        while (!isFinish) {
            Out.clear();
            Out.print("Администрирование\n" +
                    "Введите цифру для выбора варианта\n" +
                    "1 - Заблокировать пользователя\n" +
                    "2 - Список пользователей и привычек (Не реализовано)\n" +
                    "0 - Назад");
            try {
                int option = InputOption.in();
                switch (option) {
                    case 1: {
                        isFinish = true;
                        AdminController.block(user);
                        break;
                    }
                    case 2: {
                        throw new Exception("Данная функция не реализована!");
                    }
                    case 0: {
                        isFinish = true;
                        StatisticController.back(user);
                        break;
                    }
                    default: {
                        ErrorOut.show(new Exception("Выберите из вариантов 0-2!"));
                        break;
                    }
                }
            } catch (Exception ex) {
                ErrorOut.show(ex);
            }
        }
    }
}
