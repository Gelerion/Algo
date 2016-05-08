package com.denis.shuvalov.algo.recursion.exercises;

/**
 * modify the recursive binary search algorithm so that it returns the
 * index of the target in the sequence or −1
 */
public class RecursiveBinarySearchIndex {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        System.out.println(binarySearch(arr, 16, 0, arr.length - 1));


    }

    static int binarySearch(int[] arr, int num, int low, int high) {
        if (low > high) return -low;

        int mid = (low + high) / 2;
        if (num == arr[mid]) return mid;
        else if (num > arr[mid]) return binarySearch(arr, num, mid + 1, high);
        else return binarySearch(arr, num, low, mid - 1);
    }

}
