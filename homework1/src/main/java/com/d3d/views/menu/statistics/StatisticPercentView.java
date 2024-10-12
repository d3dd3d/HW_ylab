package com.d3d.views.menu.statistics;

import com.d3d.controllers.statistics.StatisticController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class StatisticPercentView {
    public static void show(User user) {
        try {
            Out.print("Выберите период\n" +
                    "1 - День\n" +
                    "2 - Неделя\n" +
                    "3 - Месяц");
            int periodCode = InputOption.in();
            if ((periodCode > 0) && (periodCode < 4)) {
                int percent = StatisticController.percentComplete(periodCode, user);
                Out.print("Процент выполнения: " + percent + "%");
                SuccesOut.show();
            } else {
                throw new Exception("Неверно введен период!");
            }

        } catch (Exception ex) {
            ErrorOut.show(ex);
        }
        Input.skip();
        StatisticController.menu(user);

    }
}
