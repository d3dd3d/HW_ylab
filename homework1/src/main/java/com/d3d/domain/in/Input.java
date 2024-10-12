package com.d3d.domain.in;

import java.util.Scanner;

public class Input {
    /**
     * Отвечает за пользовательский ввод
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Делает задержку в пользовательском вводе, позволяя пользователю прочесть информацию на экране
     */
    public static void skip(){
        scanner.nextLine();
    }
}
