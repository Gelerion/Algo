package com.denis.shuvalov.other.designPatterns.strategy;

public class QuickSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        System.out.println("QuickSorter");
        return new int[0];
    }
}
