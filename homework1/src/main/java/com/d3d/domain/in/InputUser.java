package com.d3d.domain.in;

import com.d3d.domain.model.User;

public class InputUser {
    /**
     * Отвечает за вводимые пользователем параметры при регистрации
     * @return Возвращает пользователя
     * @throws Exception Выбрасывает исключении при неправильном количестве параметров
     */
    public static User in() throws Exception{
        try{
            String inputLine = Input.scanner.nextLine();
            String[] params = inputLine.split(" ");
            if(params.length!=3){
                throw new Exception("Неверное количество параметров!");
            }

            return new User(params[0], params[2], params[1], false);
            
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
    }

    /**
     * Отвечает за ввод параметров пользователем при входе
     * @return Возвращает пользователя
     * @throws Exception Выбрасывает исключении при неправильном количестве параметров
     */
    public static User authIn() throws Exception{
        try{
            String inputLine = Input.scanner.nextLine();
            String[] params = inputLine.split(" ");
            if(params.length!=2){
                throw new Exception("Неверное количество параметров!");
            }

            return new User("null", params[1], params[0], false);
            
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
