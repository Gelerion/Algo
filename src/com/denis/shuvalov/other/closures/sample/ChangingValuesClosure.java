package com.denis.shuvalov.other.closures.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * because a and b are implicitly final, so they act as constants at the time the function is evaluated.
 * But sure, they may vary. The fact that they are final (implicitly in Java 8, explicitly in previous versions)
 * is only a way for the compiler to optimize compilation. The compiler does not care at all about the potentially
 * changing values. What it cares about is that the references do not change. In other word, it wants the reference
 * to the Integer objects a and b not to change, but it does not care about the values.
 */
public class ChangingValuesClosure {
    Integer b = 2;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        ChangingValuesClosure calculator = new ChangingValuesClosure();

        System.out.println(calculator.calculate(list.stream(), new Int(3)).collect(toList())); //[5, 8, 11, 14, 17]
    }

    public Integer getB() {
        return b;
    }

    /**
     * f(x, a, b) = x * a + b
     */
    private Stream<Integer> calculate(Stream<Integer> stream, final Int a) {
        return stream.map(x -> x * a.value + getB());
    }

    private static class Int {
        private int value;

        Int(int value) {
            this.value = value;
        }
    }
}
