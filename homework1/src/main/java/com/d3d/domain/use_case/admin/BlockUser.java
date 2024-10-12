package com.d3d.domain.use_case.admin;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;

public class BlockUser {
    /**
     * Блокирует пользователя в системе
     * @param userBlock Пользователь для блокировки
     * @throws Exception Выкидывает исключение "Данный пользователь уже заблокирован"
     */
    public static void block(User userBlock) throws Exception{
        User user = Data.getUserList().find(userBlock.getEmail());
        if(user.isBlocked())
            throw new Exception("Данный пользователь уже заблокирован!");
        user.setBlocked(true);
    }
}
