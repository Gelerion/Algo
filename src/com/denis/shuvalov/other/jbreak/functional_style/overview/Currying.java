package com.denis.shuvalov.other.jbreak.functional_style.overview;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * КАРРИРОВАНИЕ
 * <p>
 * Преобразование функции от многих аргументов в функцию,
 * берщую свои аргументы по одному
 */
public class Currying {
    public static void main(String[] args) {
        Currying c = new Currying();

        int sum = c.currySum().apply(1).apply(3).applyAsInt(2); //builder fp like code
        System.out.println("sum = " + sum);

        int sum1 = c.openCurrySum().apply(1).apply(3).applyAsInt(2);
        System.out.println("sum1 = " + sum1);

        IntFunction<IntFunction<IntUnaryOperator>> uf  = c.currySum();
        IntFunction<IntUnaryOperator>              uf1 = uf.apply(1);

    }

    int sum(int x, int y, int z) {
        return x + y + z;
    }

    IntFunction<IntFunction<IntUnaryOperator>> currySum() {
        return x -> y -> z -> sum(x, y, z);
    }

    IntFunction<IntFunction<IntUnaryOperator>> openCurrySum() {
        return new IntFunction<IntFunction<IntUnaryOperator>>() {

            @Override
            public IntFunction<IntUnaryOperator> apply(int x) {
                return new IntFunction<IntUnaryOperator>() {

                    @Override
                    public IntUnaryOperator apply(int y) {

                        return new IntUnaryOperator() {
                            @Override
                            public int applyAsInt(int z) {
                                return sum(x, y, z);
                            }
                        };
                    }
                };
            }
        };
    }
}
