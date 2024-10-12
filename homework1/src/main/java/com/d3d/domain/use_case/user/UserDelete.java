package com.d3d.domain.use_case.user;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;

public class UserDelete {
    /**
     * Удаляет пользователя из системы
     * @param user Пользователь для удаления
     */
    public static void delete(User user){
        Data.getUserList().getList().remove(user.getEmail());
        Data.getHabitList().list.remove(user.getEmail());
        Data.getUserHistory().getList().remove(user.getEmail());
    }
}
