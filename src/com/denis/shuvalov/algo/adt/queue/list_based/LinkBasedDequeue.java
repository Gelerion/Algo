package com.denis.shuvalov.algo.adt.queue.list_based;

import com.denis.shuvalov.algo.adt.queue.AdtDequeue;

public class LinkBasedDequeue<T> implements AdtDequeue<T> {
    private SingleNode<T> left;
    private SingleNode<T> right;
    private int size;

    @Override
    public void insertLeft(T item) {
        SingleNode<T> node = new SingleNode<>(item);
        if (isEmpty()) {
            left = node;
            right = node;
        }
        else {

        }

        size++;
    }

    @Override
    public void insertRight(T item) {

    }

    @Override
    public T removeLeft() {
        return null;
    }

    @Override
    public T removeRight() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {

    }
}
