package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Describe an efficient recursive algorithm for solving the element uniqueness
 * problem, which runs in time that is at most O(n2) in the worst case without using
 * sorting.
 */
public class UniquenessProblem {
    public static void main(String[] args) {
        int[] data = {4, 23, 3, 3, 22, 7, 8, 2, 5, 10};

        System.out.println(isUnique(data));
    }

    private static boolean isUnique(int[] data) {
        return isUnique(data, 0, 1);
    }

    private static boolean isUnique(int[] data, int index, int fromIndex) {
        if (fromIndex == data.length - 1) return true;
        return compareAllElementsWithCurrent(data, data[index], fromIndex) ? false : isUnique(data, ++index, ++fromIndex);
    }

    private static boolean compareAllElementsWithCurrent(int[] data, int currentElem, int index) {
        if (index == data.length - 1) return data[index] == currentElem;
        else {
            if (data[index] == currentElem) {
                return true;
            } else {
                return compareAllElementsWithCurrent(data, currentElem, ++index);
            }
        }
    }
}

