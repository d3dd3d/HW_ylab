package com.d3d.domain.in;


import java.text.SimpleDateFormat;
import java.util.Date;

public class InputDate {
    /**
     * Отвечает за ввод пользователем даты
     * @return Дату, которую пользователь ввел
     * @throws Exception Выбрасывает исключение "Неверный формат даты"
     */
    public static Date in() throws Exception{
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String dateLine = Input.scanner.nextLine();
            return dateFormat.parse(dateLine);
        }
        catch(Exception ex){
            throw new Exception("Неверный формат даты");
        }
    }
}
