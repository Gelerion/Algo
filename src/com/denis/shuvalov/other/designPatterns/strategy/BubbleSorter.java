package com.denis.shuvalov.other.designPatterns.strategy;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Bubble sort");
        return new int[0];
    }
}
