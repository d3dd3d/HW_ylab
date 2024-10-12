package com.d3d.views.menu.statistics;

import com.d3d.controllers.statistics.StatisticController;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;

public class StatisticView {
    public static void show(User user) {
        boolean isFinish = false;
        while (!isFinish) {
            Out.clear();
            Out.print("Статистика и аналитика\n" +
                    "Введите цифру для выбора варианта\n" +
                    "1 - Просмотр текущей серии\n" +
                    "2 - Процент успешного выполнения привычек\n" +
                    "0 - Назад");
            try {
                int option = InputOption.in();
                switch (option) {
                    case 1: {
                        Out.print("Текущая серия: " + StatisticController.streak(user));
                        break;
                    }
                    case 2: {
                        isFinish = true;
                        StatisticController.percent(user);
                        break;
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
