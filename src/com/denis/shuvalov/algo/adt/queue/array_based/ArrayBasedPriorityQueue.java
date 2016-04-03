package com.denis.shuvalov.algo.adt.queue.array_based;

import com.denis.shuvalov.algo.adt.queue.AdtPriorityQueue;

import java.util.Arrays;

public class ArrayBasedPriorityQueue implements AdtPriorityQueue<Integer> {
    private int[] array;
    private int maxSize;
    private int size = 0;

    public ArrayBasedPriorityQueue(int capacity) {
        maxSize = capacity;
        array = new int[maxSize];
    }

    public void insert0(int value) {
        int i;

        if (size == 0) {
            array[size++] = value;
        }
        else
        {
            for (i = size - 1; i >= 0; i--) {
                if (value > array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }

            array[i + 1] = value;
            size++;
        }
    }

    @Override
    public void insert(Integer value) {
        if(size == 0)  {
            array[size++] = value;
            return;
        }

        for (int i = 0; i <= size; i++) {
            if (Integer.compare(array[i], value) == -1) {
                int[] copyOfRange = Arrays.copyOfRange(array, i, size);
                array[i] = value;
                System.arraycopy(copyOfRange, 0, array, ++i, copyOfRange.length);
                size++;
                return;
            }
        }
    }

    @Override
    public Integer remove() {
        if(isEmpty()) return -1;
        return array[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----- Display -----");
        System.out.println("AdtQueue size: " + size);
        System.out.println("AdtQueue max size: " + maxSize);
        System.out.println("---------------");

        for (int i = maxSize - 1; i > -1; i--) {
                System.out.println("[" + array[i] + "]");
        }
        System.out.println("---------------");
    }
}
