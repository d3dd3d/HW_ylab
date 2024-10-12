package com.d3d.domain.out;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.List;

import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.Regularity;
import com.d3d.domain.model.User;

public class Out {
    public static PrintStream out = System.out;
    /**
     * Печать текста на экран
     * @param line Текст
     */
    public static void print(String line){
        out.println(line);
    }

    /**
     * Очищает экран
     */
    public static void clear(){
        out.flush();
    }

    /**
     * Выводит пользователя на экран
     * @param user Пользователь
     * @return Возвращает строку с данными пользователя
     */
    public static String printUser(User user){
        return String.format("%s   %s", user.getName(), user.getEmail());
    }

    /**
     * Выводит на экран привычки пользователя
     * @param list Список привычек пользователя
     */
    public static void printListHabit(List<Habit> list){
        print(String.format("    %15s %25s %13s %12s %3s %n", "Название","Описание","Дата создания","Частота","Активно"));
        int number = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (Habit habit : list) {
            print(String.format("%3s %15s %25s %13s %12s %3s %n", 
                number, 
                habit.getName(), 
                habit.getDescription(), 
                dateFormat.format(habit.getDateCreation()), 
                habit.getRegularity() == Regularity.DAY ? "Ежедневно" : "Еженедельно", 
                habit.isActive() ? "Да" : "Нет"));
            number++;
        }
    }

    /**
     * Выводит на экран список истории привычек пользователя
     * @param list Список истории привычек пользователя
     */
    public static void printListHabitEntry(List<HabitEntry> list){
        print(String.format("    %15s %13s %9s %n", "Название","Дата выполнения","Выполнено"));
        int number = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (HabitEntry habitEntry : list) {
            print(String.format("%3s %15s %13s %9s %n", 
                number, 
                habitEntry.habitName(),
                dateFormat.format(habitEntry.getDateHabit()), 
                habitEntry.isDone() ? "Да" : "Нет"));
            number++;
        }
    }

    /**
     * Выводит на экран список пользователей
     * @param list Список пользователей
     */
    public static void printUsers(List<User> list){
        print(String.format("    %15s %20s %10s %n", "Имя","email","Блокировка"));
        int number = 1;
        for (User user : list) {
            print(String.format("%3s %15s %20s %10s %n", 
                number, 
                user.getName(), 
                user.getEmail(),
                user.isBlocked() ? "Да" : "Нет"));
            number++;
        }
    }
}
