package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Give a recursive algorithmto compute the product of two positive integers, m and
 * n, using only addition and subtraction.
 */
public class IntegersProduct {
    public static void main(String[] args) {
        System.out.println("Mult: " + multiply(6, 6));
        System.out.println("Div: " + divide(22, 3));
//        System.out.println("Pow: " + pow(3, 4)); //81
    }

//    private static int pow(int one, int two) {
//        if(two == 0) return 1;
//        int mult = multiply(one, one);
//        return inPow(one, mult);
//
//
//
//
//        if(two == 0) return 1;
//        int multiply = multiply(one, one);
//        System.out.println("multiply = " + multiply);
//        return multiply(one, one) + pow(one, --two);
//    }

    private static int inPow(int one, int count) {
        return multiply(one, count);
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
