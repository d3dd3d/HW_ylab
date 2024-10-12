package com.d3d.domain.in;

public class InputOption {
    /**
     * Отвечает за ввод числовых параметров, вводимых пользователем
     * @return Возвращает число, вводимое пользователем
     * @throws Exception Выбрасывает исключение "Неверный ввод"
     */
    public static int in() throws Exception{
        try{
            int res = Input.scanner.nextInt();
            Input.skip();
            return res;
        }
        catch(Exception ex){
            throw new Exception("Неверный ввод, повторите попытку!");
        }
    }
}
