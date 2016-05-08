package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Describe a recursive algorithm for finding the maximum element in an array, A,
 * of n elements.
 */
public class ArrayMax {
    public static void main(String[] args) {
        int[] data = {4, 3, 6, 14, 2, 7, 8, 9, 5, 10};

        System.out.println(findMax(data));
    }

    static int findMax(int[] array) {
        return findMax(array, 1, array[0]);
    }

    private static int findMax(int[] array, int index, int currentMax) {
        if (index == array.length) return currentMax;
        else currentMax = currentMax < array[index] ? array[index] : currentMax;
        return findMax(array, ++index, currentMax);
    }
}
