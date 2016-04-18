package com.denis.shuvalov.algo.recursion.sample.binary;

/**
 * Computing the sum of one or zero
 * values is trivial. With two or more values, we can recursively compute the sum of
 * the first half, and the sum of the second half, and add those sums together.
 */
public class BinarySum {

    static int binarySum(int[] data, int low, int high) {
        if (low > high) return 0;
        else if (low == high) return data[low];
        else {
            int mid = (low + high) / 2;
            System.out.println("mid = " + mid);
            int lowValue = binarySum(data, low, mid);
            System.out.println("lowValue = " + lowValue);
            int highValue = binarySum(data, mid + 1, high);
            System.out.println("highValue = " + highValue);
            return lowValue + highValue;
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 8, 9, 3};
        System.out.println(binarySum(data, 0, data.length - 1));
    }
}
