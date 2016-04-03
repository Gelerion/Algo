package com.denis.shuvalov.algo.adt.stack.array_based;

import com.denis.shuvalov.algo.adt.stack.AdtStack;

public class ArrayStack<T> implements AdtStack<T> {
    Object array[];
    int capacity;
    int size;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        //not empty
        return (T) array[--size];
    }

    public void push(T value) {
        //not full
        array[size++] = value;
    }
}
