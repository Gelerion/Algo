package com.denis.shuvalov.algo.adt.queue.list_based;

import com.denis.shuvalov.algo.adt.queue.AdtDeque;

public class LinkBasedDeque<T> implements AdtDeque<T> {
    private SingleNode<T> first;
    private SingleNode<T> last;
    private int size;

    @Override
    public void insertLeft(T item) {
        SingleNode<T> node = new SingleNode<>(item, first);
        if (isEmpty()) {
            first = node;
            last = node;
        }
        else {
            first = node;
        }
        size++;
    }

    @Override
    public void insertRight(T item) {
        SingleNode<T> node = new SingleNode<>(item);
        if (isEmpty()) {
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T removeLeft() {
        if (isEmpty()) {
            return null;
        }
        T result = first.item;

        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
        }

        size--;
        return result;
    }

    @Override
    public T removeRight() {
        if (isEmpty()) {
            return null;
        }
        T result = last.item;

        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            SingleNode<T> tmp = first;
            while (tmp.next != last) {
                tmp = tmp.next;
            }
            last = tmp;
            last.next = null;
        }

        size--;
        return result;
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
        System.out.println("Size: " + size());
        if (size == 0)
            System.out.println("Empty Queue");
        else if (size() == 1)
            System.out.print("Forward: " + first + "\n");
        else
            System.out.print("Forward: " + first + " -> ");
        SingleNode<T> tmp = null;
        if (!isEmpty()) tmp = first.next;
        while (tmp != null) {
            if (tmp.next == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }
    }
}
