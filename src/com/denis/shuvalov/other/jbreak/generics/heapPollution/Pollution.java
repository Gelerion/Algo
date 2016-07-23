package com.denis.shuvalov.other.jbreak.generics.heapPollution;

import java.util.List;

public class Pollution {

    //Warning: possible heap pollution
    //Ситуация в которой параметаризованный тип ссылается на другой параметаризованный тип
    // List<String> = List<Integer>
    public void run(List<String>... lists) {
        //Ковариантность
        Number[] numbers = new Integer[10];
        //List<Number> nums = new ArrayList<Integer>(); //Incompatible types!

        //Not type safe at runtime!
        numbers[0] = 9.7d; //-> ArrayStoreException
        //Generics ARE Type Safe
    }

}
