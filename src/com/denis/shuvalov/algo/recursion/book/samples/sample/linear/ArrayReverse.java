package com.denis.shuvalov.algo.recursion.book.samples.sample.linear;

import java.util.Arrays;

public class ArrayReverse {

    static void reverse(int[] data, int low, int high) {
        if (low > high) return;
        int tmp = data[high];
        data[high] = data[low];
        data[low] = tmp;

        reverse(data, low + 1, high - 1);
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 7, 8, 9, 5};
        reverse(data, 0, data.length - 1);
        System.out.println("data = " + Arrays.toString(data));
    }
}
