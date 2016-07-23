package com.denis.shuvalov.other.jbreak.generics.heapPollution;

import java.util.ArrayList;
import java.util.List;

public class GenericArray {
    void method() {
        //        List<Number>[] lists = new ArrayList<Number>[10]; // Error -> Generic array creation
        //        Because:
        //        Object[] objects = lists
        //        objects[0] = new ArrayList<String>()
        //        lists[0].add(1L) -> error

        List<?>[] lists = new ArrayList<?>[10]; //Ok
    }
}
