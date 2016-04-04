package com.denis.shuvalov.algo.adt.queue;

/**
 * Дек (deque) представляет собой двустороннюю очередь. И вставка, и удаление
 * элементов могут производиться с обоих концов.
 * <p>
 * Если ограничиться только методами insertLeft() и removeLeft() (или их эквива-
 * лентами для правого конца), дек работает как стек. Если же ограничиться методами
 * insertLeft() и removeRight() (или противоположной парой), он работает как очередь.
 */
public interface AdtDeque<T> {

    void insertLeft(T item);

    void insertRight(T item);

    T removeLeft();

    T removeRight();

    boolean isEmpty();

    int size();

    void display();
}
