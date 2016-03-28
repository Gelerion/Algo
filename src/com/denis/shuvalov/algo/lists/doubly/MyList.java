package com.denis.shuvalov.algo.lists.doubly;

interface MyList<T> {

    void insertFirst(T elem);

    void insertLast(T elem);

    boolean insertAfter(T key, T elem);

    T deleteFirst();

    T deleteLast();

    T deleteKey(T elem);

    void displayForward();

    void displayBackward();

    boolean isEmpty();

}
