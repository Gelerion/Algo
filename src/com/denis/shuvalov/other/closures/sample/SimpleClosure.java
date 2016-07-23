package com.denis.shuvalov.other.closures.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * A closure is the fact, for a function, to be able to access something in the enclosing context.
 * In functional programming, the result of a function should only depend upon its arguments.
 * Closures clearly break this rule.
 */
//https://dzone.com/articles/whats-wrong-java-8-currying-vs
public class SimpleClosure {

    //outside argument
    Integer b = 2;

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    public static void main(String[] args) {
        SimpleClosure c = new SimpleClosure();

        System.out.println(c.calculate(c.list.stream(), 3).collect(toList())); //[5, 8, 11, 14, 17]
    }

    /**
     * the mapping of the function f(x) = x * 3 + 2
     */
    Stream<Integer> calculate(Stream<Integer> stream, Integer a) {
        return stream.map(i -> i * a + b);
    }

}