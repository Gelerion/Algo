package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Describe a recursive algorithm that will check if an array A of integers contains
 * an integer A[i] that is the sum of two integers that appear earlier in A, that is, such
 * that A[i] = A[j] + A[k] for j, k < i.
 */

/**
 * Isabel has an interesting way of summing up the values in an array A of n integers,
 * where n is a power of two. She creates an array B of half the size of A and sets
 * B[i] = A[2i]+ A[2i+ 1], for i = 0,1, . . . , (n/2)− 1. If B has size 1, then she
 * outputs B[0]. Otherwise, she replaces A with B, and repeats the process.
 */
public class FindBySpecificCondition {
    public static void main(String[] args) {
        int[] array = {12, 4, 18, 24, 43, 28, 5, 3, 68, 29}; //18 + 24 = 42
        //24 + 43 = 67
        System.out.println("Result: " + findSpecific(array, 2));
    }

    /**
     * Describe a recursive algorithm that will check if an array A of integers contains
     * an integer A[i] that is the sum of two integers that appear earlier in A, that is, such
     * that A[i] = A[j] + A[k] for j, k < i.
     */
    static boolean findSpecific(int[] array, int currentIndex) {
        boolean result = false;
        if (currentIndex > array.length - 1) return result;

        int k = array[currentIndex];

        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                int sum = array[i] + array[j];

                if (sum == k) {
                    System.out.println(array[i] + " + " + array[j] + " = " + sum);
                    result = true;
//                    break;
                }
            }
//            int sum = array[i] + array[i + 1];
//            if(sum == k)  {
//                System.out.println(array[i] + " + " + array[i + 1] + " = " + sum);
//                result = true;
//                break;
//            }
        }

        if (!result) {
            return findSpecific(array, ++currentIndex);
        }

        return result;
    }
}
