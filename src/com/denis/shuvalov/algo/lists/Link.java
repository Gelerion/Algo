package com.denis.shuvalov.algo.lists;

public class Link {
    public int key;
    public double value;
    public Link next;

    public Link(int key, double value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " - " + value;
    }
}
