package com.denis.shuvalov.algo.recursion.exercises;

/**
 * 1 + 1/2 + 1/3 + ... + 1/n
 */
public class HarmonicNumber {

    public static void main(String[] args) {
        System.out.println(calculate(5));
    }

    static double calculate(int n) {
        if (n == 1) return 1;
        return ((double) 1 / n) + calculate(n - 1);
    }
}
