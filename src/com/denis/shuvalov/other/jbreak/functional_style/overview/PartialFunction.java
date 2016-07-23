package com.denis.shuvalov.other.jbreak.functional_style.overview;

import java.util.function.IntBinaryOperator;

/**
 * ЧАСТИЧНОЕ ПРИМЕНЕНИЕ ФУНКЦИИ
 * <p>
 * Процесс фиксации части аргментов функции, который создает другую функцию,
 * меньше арности
 */
public class PartialFunction {

    public static void main(String[] args) {
        PartialFunction f = new PartialFunction();

        IntBinaryOperator biSum = f.partialSum(1);

        int sum1 = biSum.applyAsInt(3, 2);
        System.out.println("sum1 = " + sum1);
        int sum2 = biSum.applyAsInt(4, 5);
        System.out.println("sum2 = " + sum2);
    }

    int sum(int x, int y, int z) {
        return x + y + z;
    }

    IntBinaryOperator partialSum(int x) {
        return (y, z) -> sum(x, y, z);
    }
}
