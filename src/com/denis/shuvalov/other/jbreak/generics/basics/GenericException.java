package com.denis.shuvalov.other.jbreak.generics.basics;

//Error: Generic class may not extends Throwable
public class GenericException<T> /*extends Exception*/ {
    //Нельзя параметаризировать
    // - Классы имеющие в предках Throwable
    // - Анонимные классы
    // - Enums

    //Так не можем, у нас нет этой информации в рантайме
/*    try {
        run();
    } catch(GenericException<String> e) {
        ...
    } catch(GenericException<Integer> e)*/
}
