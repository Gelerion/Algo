package com.denis.shuvalov.algo.lists.iterator;

interface CustomListIterator<T> {

    /**
     * move iterator to the first element
     */
    void reset();

    /**
     * move iterator to the next node
     */
    void nextNode();

    T getCurrent();

    /**
     * true if at end
     */
    boolean atEnd();

    void insertAfter(T key, T elem);

    void insertBefore(T key, T elem);

    void deleteCurrent();
}
