package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Describe a way to use recursion to compute the sum of all the elements in an
 * n×n (two-dimensional) array of integers.
 */
public class TowDimensionArraySum {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {1, 5, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };

        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }

        System.out.println("Iterative total: " + total); //43
        System.out.println("Recursive total: " + sum(array));
    }

    static int sum(int[][] array) {
        return sum(array, array.length - 1);
    }

    private static int sum(int[][] array, int index) {
        if (index == 0) return innerSum(array[index], array[index].length - 1);
        else {
            int innerSum = innerSum(array[index], array[index].length - 1);
            return innerSum + sum(array, --index);
        }
    }

    private static int innerSum(int[] data, int index) {
        if (index == 0) return data[index];
        else return data[index] + innerSum(data, --index);
    }


}
