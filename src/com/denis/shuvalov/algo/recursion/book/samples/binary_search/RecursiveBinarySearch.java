package com.denis.shuvalov.algo.recursion.book.samples.binary_search;

public class RecursiveBinarySearch {

    static boolean binarySearch(int[] data, int item, int low, int high) {
        if (low > high) return false;
        int mid = (high + low) / 2;
        if (data[mid] == item) return true;

        if (item > data[mid])
            //low = mid + 1
            return binarySearch(data, item, mid + 1, high);
        else
            //high = mid - 1
            return binarySearch(data, item, low, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        System.out.println(RecursiveBinarySearch.binarySearch(arr, 33, 0, arr.length - 1) ? "Found" : "Not Found");
    }
}
