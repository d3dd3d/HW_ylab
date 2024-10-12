package com.d3d.domain.in;

import com.d3d.domain.model.Habit;
import com.d3d.domain.model.Regularity;
import com.d3d.domain.model.User;

public class InputHabit {
    /**
     * Отвечает за ввод привычки пользователем
     * @param user Пользователь, которому добавляется привычка
     * @return Возвращает привычку
     * @throws Exception Выбрасывает исключение "Неверное количество параметров" или "Неверная частота привычки"
     */
    public static Habit in(User user) throws Exception{
        try{
            String inputLine = Input.scanner.nextLine();
            String[] params = inputLine.split(" ");
            if(params.length!=3){
                throw new Exception("Неверное количество параметров!");
            }
            Regularity regularityEnum;
            int regularity = Integer.parseInt(params[2]);
                switch (regularity) {
                    case 1:{
                        regularityEnum = Regularity.DAY;
                        break;
                    }
                    case 2:{
                        regularityEnum = Regularity.WEEK;
                        break;
                    }
                    default:{
                        throw new Exception("Неверная частота привычки");
                    }
                }

            return new Habit(params[0], user.getEmail(), params[1], regularityEnum);
            
        }
        catch(NumberFormatException ex){
            throw new Exception("Неверный формат частоты");
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
    }
}
