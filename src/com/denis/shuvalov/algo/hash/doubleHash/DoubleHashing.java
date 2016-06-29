package com.denis.shuvalov.algo.hash.doubleHash;

import java.util.Arrays;

public class DoubleHashing {
    public static final int CONST = 5;
    private int[] table;
    private int capacity;
    private int size;

    DoubleHashing(int capacity) {
        this.table = new int[capacity];
        this.capacity = capacity;
    }

    void insert(int key) {
        ensureCapacity();
        size++;

        int primary = hashPrimary(key);
        System.out.println("[INSERT] Value: " + key + ", hash: " + primary);

        //or null
        if (table[primary] == 0) {
            table[primary] = key;
            System.out.println("[INSERT] Inserted at index: " + primary);
            return; //inserted
        }

        boolean inserted = false;
        int step = hashStep(key);
        while (!inserted) {
            System.out.println("[INSERT] Step hash: " + step);
            primary += step;

            if (table[primary % capacity] == 0) {
                System.out.println("[INSERT] Inserted at index: " + primary % capacity);
                table[primary % capacity] = key;
                inserted = true;
            }
        }
    }

    int find(int key) {
        int primary = hashPrimary(key);

        if (table[primary] == key) {
            System.out.println("[FIND] Found at index: " + primary);
            return table[primary];
        }

        int step = hashStep(key);
        while (true) {
            primary += step;

            if (table[primary % capacity] == key) {
                System.out.println("[FIND] Found at index: " + primary % capacity);
                return table[primary % capacity];
            }
        }
    }

    @Override
    public String toString() {
        return "DoubleHashing{" +
                "table=" + Arrays.toString(table) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }

    private int hashStep(int key) {
        return CONST - (key % CONST);
    }

    private int hashPrimary(int key) {
        return key % capacity;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            //TODO: resize
        }
    }

}
