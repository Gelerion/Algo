package com.denis.shuvalov.algo.recursion.exercises;

import java.util.Arrays;

/**
 * Given an unsorted array, A, of integers and an integer k, describe a recursive
 * algorithm for rearranging the elements in A so that all elements less than or equal
 * to k come before any elements larger than k. What is the running time of your
 * algorithm on an array of n values?
 */
public class RearrangingArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrange(new int[]{4, 6, 9, 12, 2, 5}, 7)));
    }

    static int[] rearrange(int[] array, int k) {
        int[] arrangedArray = new int[array.length];
        doRearrange(array, k, arrangedArray, 0, arrangedArray.length - 1, 0);
        return arrangedArray;
    }

    private static void doRearrange(int[] array, int elem, int[] arrangedArray, int low, int high, int index) {
        if (low > high) return;

        if (elem > array[index]) {
            arrangedArray[low] = array[index];
            doRearrange(array, elem, arrangedArray, ++low, high, ++index);
        } else {
            arrangedArray[high] = array[index];
            doRearrange(array, elem, arrangedArray, low, --high, ++index);

        }
    }
}
