package com.denis.shuvalov.algo.arrays.base.infix;

import java.io.IOException;

public class InfixApp {
    public static void main(String[] args) throws IOException
    {
        String input, output;
        while(true)
        {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            // Чтение строки с клавиатуры
            if( input.equals("") ) // Выход, если нажата клавиша [Enter]
                break;
            // Создание объекта-преобразователя
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // Преобразование
            System.out.println("Postfix is " + output + '\n');
            break;
        }
    }

    public static String getString() {
        return "A+B*C/D+E";
    }
}
