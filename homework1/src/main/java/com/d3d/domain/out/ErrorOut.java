package com.d3d.domain.out;

public class ErrorOut {
    /**
     * Вывод исключения на экран
     * @param ex Исключение
     */
    public static void show(Exception ex){
        Out.out.println(ex.getMessage());
        Out.out.println("Нажмите enter для продолжения");
    }
}
