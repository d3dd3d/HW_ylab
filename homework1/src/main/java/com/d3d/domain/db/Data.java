package com.d3d.domain.db;

import com.d3d.domain.model.HabitList;
import com.d3d.domain.model.UserHistory;
import com.d3d.domain.model.UserList;

public class Data {
    private static UserList userList = new UserList();
    private static HabitList habitList = new HabitList();
    private static UserHistory userHistory = new UserHistory();

    /**
     * Список пользователей
     * @return Возвращает список пользователей
     */
    public static UserList getUserList() {
        return userList;
    }
    /**
     * Список всех привычек
     * @return Возвращает список всех привычек
     */
    public static HabitList getHabitList() {
        return habitList;
    }
    /**
     * Список всех историй привычек
     * @return Возвращает список всех историй привычек
     */
    public static UserHistory getUserHistory() {
        return userHistory;
    }
    
}
