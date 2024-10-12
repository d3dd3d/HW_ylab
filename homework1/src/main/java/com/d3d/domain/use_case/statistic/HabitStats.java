package com.d3d.domain.use_case.statistic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;

public class HabitStats {
    /**
     * Возвращает серию выполнений привычек
     * @param currentUser Пользователь для которго высчитывает серию
     * @return Возвращает число-серию
     */
    public static int habitSeries(User currentUser) {
        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(currentUser);
        Collections.reverse(userHistory);
        SimpleDateFormat dateFormat =new SimpleDateFormat("dd.MM.yyyy");
        int minSerises = 0;
        Date currDate = new Date();
        for (HabitEntry habitEntry : userHistory) {
            if (!dateFormat.format(currDate).equals(dateFormat.format(habitEntry.getDateHabit()))) {
                currDate = habitEntry.getDateHabit();
                minSerises++;
            }
            if (!habitEntry.isDone()) {
                break;
            }

        }

        return minSerises;
    }

    /**
     * Возвращает процент выполнения привычек
     * @param periodCode Период, за который просматриваются привычки, 1 - день, 2 - неделя, 3 - месяц
     * @param currentUser Пользователь, для которго высчитывается статистика
     * @return Возвращает число-процент
     * @throws Exception Выкидывает исключение, если вывыполненных задач нету
     */
    public static int habitCompletionPercent(int periodCode, User currentUser) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 

        int period = periodCode == 1 ? 1 
            : periodCode == 2 ?  7 : 28;

        calendar.add(Calendar.DATE, -period);

        int countAll = (int)Data.getUserHistory()
            .find(currentUser)
            .stream()
            .filter(x -> x.getDateHabit().compareTo(calendar.getTime()) >= 0)
            .count();
        int countDone = (int)Data.getUserHistory()
            .find(currentUser)
            .stream()
            .filter(x -> x.isDone() == true)
            .filter(x -> x.getDateHabit().compareTo(calendar.getTime()) >= 0)
            .count();
        if(countAll==0)
            throw new Exception("Выполненных задач нет!");
        return (countDone / countAll) * 100;
    }
}
