package com.denis.shuvalov.algo.adt.queue.list_based;

class SingleNode<T> {
    T item;
    SingleNode<T> next;

    SingleNode(T item) {
        this.item = item;
    }

    SingleNode(T item, SingleNode<T> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(item);
    }
}
