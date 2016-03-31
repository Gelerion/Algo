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

    //insert after current
    void insertAfter(T elem);

    //insert before current
    void insertBefore(T elem);

    void deleteCurrent();
}
