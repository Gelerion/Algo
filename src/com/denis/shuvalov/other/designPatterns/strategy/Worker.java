package com.denis.shuvalov.other.designPatterns.strategy;

public class Worker {
    public static void main(String[] args) {
        new Clent(new QuickSorter()).doSort(null);
    }
}
