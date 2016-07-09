package com.denis.shuvalov.other.designPatterns.strategy;

public class Clent {

    private Sorter sorter;

    public Clent(Sorter sorter) {
        this.sorter = sorter;
    }

    int[] doSort(int[] data) {
        return sorter.sort(data);
    }
}
