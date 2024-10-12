package com.d3d.domain.use_case.user;

import java.util.ArrayList;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;

public class UserUpdate {

    /**
     * Обновление имени пользователя
     * @param currentUser Пользователь, которому нужно обновить имя
     * @param newName Новое имя пользователя
     * @return Возвращает true - при успехе операции, false - при ошибке
     */
    public static boolean nameUpdate(User currentUser, String newName){
        currentUser.setName(newName);
        return true;
    }

    /**
     * Обновление пароля пользователя
     * @param currentUser Пользователь, которому нужно обновить пароль
     * @param newPassword Новый пароль пользователя
     * @return Возвращает true - при успехе операции, false - при ошибке
     */
    public static boolean passwordUpdate(User currentUser, String newPassword){
        currentUser.setPassword(newPassword);
        return true;
    }

    /**
     * Обновление email пользователя
     * @param currentUser Пользователь, которому нужно обновить email
     * @param newEmail Новый email пользователя
     * @return Возвращает true - при успехе операции, false - при ошибке
     */
    public static boolean emailUpdate(User currentUser, String newEmail){
        currentUser.setEmail(newEmail);
        ArrayList<HabitEntry> userHistory = Data.getUserHistory().find(currentUser);
        for (HabitEntry habitEntry : userHistory) {
            habitEntry.setUserMail(newEmail);
        }
        return true;
    }
}
