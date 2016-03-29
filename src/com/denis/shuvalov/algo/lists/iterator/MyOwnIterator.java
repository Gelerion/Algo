package com.denis.shuvalov.algo.lists.iterator;

class MyOwnIterator<T extends Comparable<T>> implements CustomListIterator<T> {
    private Node<T> current;
    private NodeList<T> list;

    MyOwnIterator(NodeList<T> list) {
        this.list = list;

    }

    @Override
    public void reset() {
        current = list.getFirst();
    }

    @Override
    public void nextNode() {
        current.next();
    }

    @Override
    public T getCurrent() {
        return current.item();
    }

    @Override
    public boolean atEnd() {
        return current.next() == null;
    }

    @Override
    public void insertAfter(T key, T elem) {

    }

    @Override
    public void insertBefore(T key, T elem) {

    }

    @Override
    public void deleteCurrent() {

    }
}
