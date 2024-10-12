package com.d3d.views.menu.habit_edit;

import java.util.List;

import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputOption;
import com.d3d.domain.in.InputParam;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitEditUpdateView {
    public static void show(User user) {
        Out.clear();
        Out.print("Список привычек:\n");
        List<Habit> list = HabitEditController.getHabitList(user, null, 0);
        Out.printListHabit(list);
        Out.print("Выберите из списка номер привычки,\n" +
                "которую хотите поменять");
        try {
            int posistion = InputOption.in() - 1;
            if ((posistion >= 0) && (posistion < list.size())) {
                Out.print("Введите цифру для выбора варианта\n" +
                        "1 - Редактирование названия\n" +
                        "2 - Редактирование описания\n" +
                        "3 - Смена статуса\n" +
                        "4 - Редактирование частоты");
                int option = InputOption.in();
                switch (option) {
                    case 1: {
                        Out.clear();
                        Out.print("Пожалуйста введите в одну строчку\n" +
                                "название привычки");
                        String newName = InputParam.in();
                        HabitEditController.updateName(user, (Habit)list.toArray()[posistion], newName);
                        SuccesOut.show();
                        break;
                    }
                    case 2: {
                        Out.clear();
                        Out.print("Пожалуйста введите в одну строчку\n" +
                                "описание привычки");
                        String newDescription = InputParam.in();
                        HabitEditController.updateDescription(user, (Habit)list.toArray()[posistion], newDescription);
                        SuccesOut.show();
                        break;
                    }
                    case 3: {
                        Out.clear();
                        Out.print("Пожалуйста выберите статус привычки\n" +
                                "0 - Активно\n" +
                                "1 - Неактивно");
                        int isActive = InputOption.in();
                        if((isActive==0)||(isActive==1)){
                            HabitEditController.updateStatus(user, (Habit)list.toArray()[posistion], isActive==0 ? true : false);
                            SuccesOut.show();
                        }
                        else{
                            throw new Exception("Неверно выбран статус привычки!");
                        }
                        break;
                    }
                    case 4:{
                        Out.clear();
                        Out.print("Пожалуйста выберите регулярность привычки\n" +
                                "1 - Ежедневно\n" +
                                "2 - Еженедельно");
                        int newRegularity = InputOption.in();
                        if((newRegularity==1)||(newRegularity==2)){
                            HabitEditController.updateRegularity(user, (Habit)list.toArray()[posistion], newRegularity);
                            SuccesOut.show();
                        }
                        else{
                            throw new Exception("Неверно выбран статус привычки!");
                        }
                        break;
                    }
                    default: {
                        ErrorOut.show(new Exception("Неверно введен вариант!"));
                        break;
                    }
                }
            } else {
                throw new Exception("Неверно введен номер привычки!");
            }

        } catch (Exception ex) {
            ErrorOut.show(ex);
        }
        Input.skip();
        HabitEditController.menu(user);

    }
}
