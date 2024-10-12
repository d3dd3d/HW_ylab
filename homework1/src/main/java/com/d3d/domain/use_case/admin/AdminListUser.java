package com.d3d.domain.use_case.admin;

import java.util.List;
import java.util.stream.Collectors;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;

public class AdminListUser {
    /**
     * Возвращает список пользователей
     * @return Список пользователей
     */
    public static List<User> getList(){
        return Data.getUserList().getList().values().stream().collect(Collectors.toList());
    }
}
