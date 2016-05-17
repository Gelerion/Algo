package com.denis.shuvalov.algo.sort.merge;

import java.util.Arrays;

public class RecursionMergeSorting {
    public static void main(String[] args) {
        sort(new int[]{64, 21, 33, 70, 12, 85, 44, 3, 97, 24, 51, 40});
    }

    static void sort(int[] array) {
        divideAndMerge(array, 0, array.length - 1);
    }

    static int[] divideAndMerge(int[] array, int low, int high) {
        if (array.length == 2) return array;

        int index = (low + high) / 2;

        int[] first = divideAndMerge(Arrays.copyOfRange(array, low, index), low, index);
        System.out.println("first = " + Arrays.toString(first));
        int[] second = divideAndMerge(Arrays.copyOfRange(array, ++index, high), ++index, high);

        System.out.println("second = " + Arrays.toString(second));

        return merge(first, second);
    }

    private static int[] merge(int[] first, int[] second) {
        return new int[]{};
    }
}
