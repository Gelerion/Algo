package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Give a recursive algorithmto compute the product of two positive integers, m and
 * n, using only addition and subtraction.
 */
public class IntegersProduct {
    public static void main(String[] args) {
        System.out.println("Mult: " + multiply(6, 6));
        System.out.println("Div: " + divide(22, 3));
        System.out.println("Pow: " + pow(5, 8)); //390625
    }

    private static int pow(int one, int second) {
        return doPow(one, one, --second);
    }

    private static int doPow(int one, int multCnt, int total) {
        if (total == 1) return multiply(one, multCnt);
        return doPow(multiply(one, multCnt), multCnt, --total);
    }

    private static int divide(int one, int two) {
        if (two > one) return 0;
        return 1 + divide(one - two, two);
    }

    private static int multiply(int one, int two) {
        if (two == 1) return one;
        return one + multiply(one, --two);
    }
}
