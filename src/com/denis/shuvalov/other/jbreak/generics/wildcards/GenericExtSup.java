package com.denis.shuvalov.other.jbreak.generics.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * PECS (Producer - extends, consumer - super)
 */
public class GenericExtSup {

    //max(List<Integer>, Comparator<Number>)
    //max(List<String>,  Comparator<Object>)
    static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        //        coll -> Producer, give us an elements
        //        comp -> Consumer, handles those elements
        return null;
    }

    public static void main(String[] args) {
        // What could i add?
        List<? extends Number> numbers = new ArrayList<>();
        //        numbers.add((Number) 1); -> error
        //        numbers.add((Integer) 1); -> error
        //        Only --> null

        //Можно присвоить
        numbers = new ArrayList<Number>();
        numbers = new ArrayList<Integer>();
        numbers = new ArrayList<Long>();

    }

    void process(List<? extends Number> numbers) {
        //        numbers.add(234L); -> Error
        // Valid only for List<Number> and List<Long>
        //What if we got List<Integer> ? Not safe
    }

    void superExample() {
        List<? super Number> numbers = new ArrayList<>();
        // Error to add(Object) !!!!
        // Valid for:
        // - all ? extends Number
        // - Number
        // - Integer
        // - Double
        // - null

        //Можно присвоить
        numbers = new ArrayList<Number>();
        numbers = new ArrayList<Object>();
        //        numbers = new ArrayList<Integer>(); Error

    }

    //Компилятор знает что лист параметаризироован максимум Number
    //поэтому можно спокойно полодить любой Number
    void superProcess(List<? super Number> numbers) {
        numbers.add(234L);
        numbers.add(100D);
        //        numbers.add(new Object()); Error!
    }
}
