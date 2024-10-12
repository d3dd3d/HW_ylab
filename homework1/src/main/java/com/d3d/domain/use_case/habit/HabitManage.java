package com.d3d.domain.use_case.habit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.Regularity;
import com.d3d.domain.model.User;

public class HabitManage {
    
    /**
     * Добавляет привычку в список привычек пользователя и создает пользователю список истории для этой привычки
     * @param habit Привычка для добавления
     * @param user Пользователь, которому добавляется привычка
     * @throws Exception Выбрасывает исключение "Имя привычки уже занято"
     */
    public static void add(Habit habit, User user) throws Exception{

        ArrayList<Habit> userHabits = Data.getHabitList().find(user);
        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(user);

        if(userHabits.size()!=0){
            boolean isUnique = userHabits.stream().noneMatch(x -> x.getName() == habit.getName());

            if(!isUnique){
                throw new Exception("Имя привычки уже занято!");
            }
        }

        HabitEntry habitEntry = new HabitEntry(habit.getName(), user.getEmail());

        userHabits.add(habit);
        userHistory.add(habitEntry);

    }

    /**
     * Обновляет название привычки пользователя
     * @param user Пользователь, которому обновляют привычку
     * @param habit Привычка для обновления
     * @param newName Новое название привычки
     */
    public static void updateName(User user, Habit habit, String newName){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);

        Optional<Habit> habs = userHabits.stream().filter(x -> x.getName() == habit.getName()).findFirst();

        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(user);
        for (HabitEntry habitEntry : userHistory) {
            habitEntry.sethabitId(newName);
        }
        
        habs.get().setName(newName);
    }

    /**
     * Обновляет описание привычки
     * @param user Пользователь, которому обновляют привычку
     * @param habit Привычка для обновления
     * @param newDescription Новое описание привычки
     */
    public static void updateDescription(User user, Habit habit, String newDescription){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);

        Optional<Habit> habs = userHabits.stream().filter(x -> x.getName() == habit.getName()).findFirst();
        habs.get().setDescription(newDescription);
    }

    /**
     * Обновляет статус привычки
     * @param user Пользователь, которому обновляют привычку
     * @param habit Привычка для обновления
     * @param newStatus Новый статус привычки
     */
    public static void updateStatus(User user, Habit habit, boolean newStatus){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);

        Optional<Habit> habs = userHabits.stream().filter(x -> x.getName() == habit.getName()).findFirst();
        habs.get().setActive(newStatus);
    }

    /**
     * Обновляет регулярность привычки
     * @param user Пользователь, которому обновляют привычку
     * @param habit Привычка для обновления
     * @param newRegularity Новыая регулярность привычки
     */
    public static void updateRegularity(User user, Habit habit, int newRegularity){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);

        Optional<Habit> habs = userHabits.stream().filter(x -> x.getName() == habit.getName()).findFirst();
        habs.get().setRegularity(newRegularity==1 ? Regularity.DAY : Regularity.WEEK);
    }

    /**
     * Удаляет привычку у пользователя и историю привычки для пользователя
     * @param user Пользователь, которому удаляют привычку
     * @param habit Привычка для удаления
     */
    public static void delete(User user, Habit habit){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);

        Optional<Habit> habs = userHabits.stream().filter(x -> x.getName() == habit.getName()).findFirst();
        userHabits.remove(habs.get());

        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(user);
        userHistory.removeIf(x -> x.habitName() == habit.getName());
    }

    /**
     * Возвращает список в зависимости от фильтров
     * @param user Пользователь, у которого берут список привычек
     * @param dateFilter Фильтр даты, все привычки возвращаются после нее, либо поставить null для сброса фильтра
     * @param statusFilterCode Фильтр статуса привычки, 1 - Активаня, 2 - Неактивная, 0 для сброса фильтра
     * @return
     */
    public static List<Habit> read(User user, Date dateFilter, int statusFilterCode){
        ArrayList<Habit> userHabits = Data.getHabitList().find(user);
        boolean statusFilter = statusFilterCode - 1 == 0 ? true : false;
        return userHabits.stream()
            .filter(x -> ((dateFilter == null) || ( dateFilter.compareTo(x.getDateCreation())<= 0)))
            .filter(x -> ((statusFilterCode == 0)||(x.isActive() == statusFilter)))
            .collect(Collectors.toList());
    }
}
