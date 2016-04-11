package com.denis.shuvalov.algo.lists.twoDimensionList;

import com.denis.shuvalov.algo.lists.cyclicList.Node;

public class DimensionList<T> {
    private Node<T> first;
    private Node<T> last;

    private int size;
    private int maxSize;

    public DimensionList(int capacity) {
        this.maxSize = capacity;
    }

    public void insert(T item) {
//        if(size > maxSize) throw new IllegalStateException("Max size reached");
        Node<T> newNode = new Node<>(item);
//        first.item = item;
        if (isEmpty()) last = newNode;
        else first.previous = newNode;
//
        newNode.next = first;
        first = newNode;
//        size++;
    }

    public void update(int index, T item) {
        //insert first
        if (index == 0) {
            first.item = item;
            return;
        }

        Node<T> tmp = this.first;
        int current = 0;
        while (index != current) {
            tmp = tmp.next;
            current++;
        }

        tmp.item = item;

    }

    public T getFirst() {
        return first.item;
    }

    public T get(int index) {
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return maxSize;
    }
}
