package com.denis.shuvalov.algo.lists.iterator;

class Node<T> {
    private T item;
    private Node<T> next;
    private Node<T> previous;

    public Node(T item) {
        this.item = item;
    }

    Node<T> next() {
        return next;
    }

    Node<T> pevious() {
        return previous;
    }

    T item() {
        return item;
    }
}
