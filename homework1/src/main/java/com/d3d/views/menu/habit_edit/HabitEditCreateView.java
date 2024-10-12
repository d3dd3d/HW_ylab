package com.d3d.views.menu.habit_edit;

import com.d3d.controllers.habit_edit.HabitEditController;
import com.d3d.domain.in.Input;
import com.d3d.domain.in.InputHabit;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.User;
import com.d3d.domain.out.ErrorOut;
import com.d3d.domain.out.Out;
import com.d3d.domain.out.SuccesOut;

public class HabitEditCreateView {
    public static void show(User user){
        Out.clear();
        Out.print("Пожалуйста введите в одну строчку\n"+
                "через пробел название привычки, описание\n" +
                "и частоту (1 - ежедневно, 2 - еженедельно)");
        try{
            Habit habit = InputHabit.in(user);
            HabitEditController.add(habit, user);
            SuccesOut.show();
        }
        catch(Exception ex){
            ErrorOut.show(ex);
            
        }
        Input.skip();
        HabitEditController.menu(user);
        
    }
}
