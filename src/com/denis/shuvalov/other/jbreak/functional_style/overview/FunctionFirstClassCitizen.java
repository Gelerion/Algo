package com.denis.shuvalov.other.jbreak.functional_style.overview;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * ФУНКЦИИ ПЕРВОГО КЛАССА
 * язык рассматривает функции как объекты первого класса
 * !!(поддерживает передачу функций в качестве аргументов другим функциям,
 * возврат их как результат дргих функций,
 * присваивание их переменным)
 */
public class FunctionFirstClassCitizen {
    public static void main(String[] args) {
        FunctionFirstClassCitizen f = new FunctionFirstClassCitizen();

        f.test();
    }

    public int sum(int x, int y) {
        return x + y;
    }

    void test() {
        BiFunction<Integer, Integer, Integer> sum     = this::sum;
        BiFunction<Integer, Integer, Integer> sumPipe = sum.andThen(a -> a / 2);

        BinaryOperator<Integer> biSum = this::sum;

        Comparator<Integer> comSum = this::sum; //even this
    }
}
