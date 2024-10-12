package com.d3d.domain.out;

public class SuccesOut {
    /**
     * Выводит на экран информацию об успешности операции и дальнейших действий пользователю
     */
    public static void show(){
        Out.out.println("Операция успешна!");
        Out.out.println("Нажмите enter для продолжения");
    }
}
