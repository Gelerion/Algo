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

    Node<T> next(Node<T> node) {
        return next = node;
    }

    Node<T> previous() {
        return previous;
    }

    Node<T> previous(Node<T> node) {
        return previous = node;
    }

    T item() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
