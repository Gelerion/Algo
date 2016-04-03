package com.denis.shuvalov.algo.adt.queue;

//only relevant methods
public interface AdtPriorityQueue<T> {
    void insert(T elem);
    T remove();
    void display();
    boolean isEmpty();
}
