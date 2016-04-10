package com.denis.shuvalov.algo.lists.cyclicList;

public class Node<T> {
    public T item;
    public Node<T> next;
    public Node<T> previous;

    public Node(T item) {
        this.item = item;
    }

    public Node(Node<T> previous, T item, Node<T> next) {
        this.previous = previous;
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(item);
    }
}
