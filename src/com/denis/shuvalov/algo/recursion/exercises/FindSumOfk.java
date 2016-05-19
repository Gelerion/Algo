package com.denis.shuvalov.algo.recursion.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose you are given an array, A, containing n distinct integers that are listed
 * in increasing order. Given a number k, describe a recursive algorithm to find two
 * integers in A that sum to k, if such a pair exists. What is the running time of your
 * algorithm?
 */
public class FindSumOfk {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        int k = 11;
        System.out.println(find(array, k, 0, array.length - 1));
    }

    static List<Pair> find(int[] array, int k, int left, int right) {
        List<Pair> result = new ArrayList<>();
        if (left > right) return result;

        int sum = array[left] + array[right];
        if (k == sum) {
            result.add(new Pair().setA(array[left]).setB(array[right]));
            result.addAll(find(array, k, ++left, --right));
        } else if (sum > k) {
            result.addAll(find(array, k, left, --right));
        } else {
            result.addAll(find(array, k, ++left, right));
        }

        return result;
    }

    private static class Pair {
        int a;
        int b;

        public Pair setA(int a) {
            this.a = a;
            return this;
        }

        Pair setB(int b) {
            this.b = b;
            return this;
        }

        @Override
        public String toString() {
            return "{" + a + "," + b + "}";
        }
    }
}
