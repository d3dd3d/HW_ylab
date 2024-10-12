package com.d3d.domain.use_case.habit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;

public class HabitWatch {
    /**
     * Отметить привычку выполненной
     * @param currentUser Пользователь, который отмечает привычку
     * @param habit Привычка для выполнения
     */
    public static void habitDone(User currentUser,HabitEntry habit){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(currentUser);
        Optional<HabitEntry> habitEntry = userHistory
        .stream()
        .filter(x -> dateFormat.format(x.getDateHabit()).equals(dateFormat.format(new Date())))
        .findFirst();
        habitEntry.get().setDone(true);
    }

    /**
     * Возвращает список истории привычек для пользователя
     * @param user Пользователь, для которого возвращается список
     * @return Возвращает список истории привычек для пользователя
     */
    public static List<HabitEntry> historyList(User user){
        return Data.getUserHistory().find(user);
    }

    /**
     * Возвращает список истории привычек для нынешней даты
     * @param user Пользователь, для которого возвращается список
     * @return Возвращает список истории привычек для нынешней даты
     */
    public static List<HabitEntry> habitTodayList(User user){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return Data.getUserHistory().find(user)
        .stream()
        .filter(x -> dateFormat.format(x.getDateHabit()).equals(dateFormat.format(new Date())))
        .collect(Collectors.toList());
    }

    /**
     * Возвращает список истории для привычки по периодам
     * @param periodCode Отвечает за временной период, по которому производится поиск, 
     * 1 - для дневного периода, 2 - для недельного, 3 - для месячного
     * @param currentUser Пользователь, для которого составляется список
     * @param habit Привычка, по которой составляется список
     * @return Возвращает список истории для привычки
     */
    public static List<HabitEntry> statistics(int periodCode, User currentUser, Habit habit){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 

        int period = periodCode == 1 ? 1 
            : periodCode == 2 ?  7 : 28;

        calendar.add(Calendar.DATE, -period);

        return Data.getUserHistory()
            .find(currentUser)
            .stream()
            .filter(x -> x.habitName()==habit.getName())
            .filter(x -> x.getDateHabit().compareTo(calendar.getTime()) >= 0)
            .collect(Collectors.toList());
    }

}
