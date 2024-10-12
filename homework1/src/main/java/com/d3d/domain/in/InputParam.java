package com.d3d.domain.in;

public class InputParam {
    /**
     * Отвечает за ввод параметра, вводимой пользователем
     * @return Возвращает строку с параметром
     * @throws Exception Выбрасывает исключение, если параметров в строке больше чем 1
     */
    public static String in() throws Exception{
        try{
            String param[] = Input.scanner.next().split(" ");
            if(param.length!=1)
                throw new Exception("Неверно введен параметр!");
            return param[0];
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
