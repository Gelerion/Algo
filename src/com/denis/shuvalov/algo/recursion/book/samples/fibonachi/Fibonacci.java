package com.denis.shuvalov.algo.recursion.book.samples.fibonachi;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(fibonacci(42)));
        System.out.println(fibonacciBad(42)); //2^n

    }

    static long[] fibonacci(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacci(n - 1);                   // returns {Fn−1, Fn−2}
            long[] answer = {temp[0] + temp[1], temp[0]};     // we want {Fn, Fn−1}
            return answer;
        }
    }

    static int fibonacciBad(int n) {
        if (n <= 1) return n;
        else return fibonacciBad(n - 2) + fibonacciBad(n - 1);
    }
}
