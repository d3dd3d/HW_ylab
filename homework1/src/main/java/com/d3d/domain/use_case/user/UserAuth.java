package com.d3d.domain.use_case.user;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;

public class UserAuth {

    /**
     * Регистрация нвого пользователя в систему
     * @param user Пользователь, которого надо зарегестрировать
     * @throws Exception Выкидывает исключения, если пользователь с таким email уже существует
     */
    public void registration(User user) throws Exception{

        boolean isUnique = Data.getUserList().find(user.getEmail()) == null ? true : false;

        if(!isUnique){
            throw new Exception("Пользователь с таким email уже зарегестрирован!");
        }

        Data.getUserHistory().addUser(user);
        Data.getHabitList().addUser(user);
        Data.getUserList().add(user);

    }

    /**
     * Отвечает за вход пользователя в систему
     * @param password Пароль пользователя
     * @param email Email пользователя
     * @return Возвращает True, если вход успешен, false, если неуспешно
     * @throws Exception Выбрасывает исключение если логин или пароль неверный, или если пользователь заблокирован
     */
    public boolean auth(String password, String email) throws Exception{

        User user = Data.getUserList().find(email);

        if(user==null){
            throw new Exception("Неверный логин или пароль");
        }

        if(user.isBlocked()){
            throw new Exception("Данный пользователь заблокирован!");
        }

        boolean isCorrect = user.getPassword().equals(password) ? true : false;

        if(!isCorrect){
            throw new Exception("Неверный логин или пароль");
        }

        
        return true;

    }

    /**
     * Проверяет старый пароль при попытке смены пароля
     * @param password Старый пароль, который необходимо проверить
     * @param email Почта пользователя, для которого идет проверка
     * @return Возвращает true - если пароль совпадает, false - если не совпадает
     * @throws Exception Выбрасывает исключение, если пароль неверный
     */
    public static boolean passwordCheck(String password, String email) throws Exception{
        User user = Data.getUserList().find(email);
        boolean isCorrect = user.getPassword() == password ? true : false;

        if(!isCorrect){
            throw new Exception("Неверный пароль");
        }

        
        return true;
    }
}
