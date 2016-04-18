package com.denis.shuvalov.algo.recursion.sample.linear;

public class ArraySumCalculator {

    static int calculate(int[] data, int index) {
        if (index == 0) return data[index];
        return data[index] + calculate(data, index - 1);
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 8, 9, 3};
        System.out.println("Sum: " + calculate(data, data.length - 1));
    }
}
