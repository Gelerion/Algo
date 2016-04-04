package com.denis.shuvalov.algo.lists.cyclicList;

class Node<T> {
    T item;
    Node<T> next;
    Node<T> previous;

    Node(T item) {
        this.item = item;
    }

    Node(Node<T> previous, T item, Node<T> next) {
        this.previous = previous;
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(item);
    }
}
