package com.denis.shuvalov.algo.lists.iterator;

class MyOwnIterator<T extends Comparable<T>> implements CustomListIterator<T> {
    private Node<T> current;
    private NodeList<T> list;

    MyOwnIterator(NodeList<T> list) {
        this.list = list;
        reset();
    }

    @Override
    public void reset() {
        current = list.getFirst();
    }

    @Override
    public void nextNode() {
        current = current.next();
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
    public void insertAfter(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (list.isEmpty()) {
            list.setFirst(newNode);
            nextNode();
        }
        else {
            newNode.previous(current);
            newNode.next(current.next());
            newNode.next().previous(newNode);
            current.next(newNode);
            nextNode();
        }
    }

    @Override
    public void insertBefore(T elem) {
/*        Node<T> newNode = new Node<>(elem);

        if (list.isEmpty()) {
            list.setFirst(newNode);
            nextNode();
        }
        else {
            newNode.previous(current);
            newNode.next(current.next());
            newNode.next().previous(newNode);
            current.next(newNode);
            nextNode();
        }*/

    }

    @Override
    public void deleteCurrent() {
        //current is first
        if (current.previous() == null) {
            list.setFirst(current.next());
            reset();
        }
        else {
            current.previous().next(current.next());

            //not last one
            if(current.next() != null)
                reset();
            else {
                current = current.next();
                current.next().previous(current.previous());
            }
        }
    }

/*    @Override
    public void insertAfter(T key, T elem) {
        Node<T> newNode = new Node<>(elem);
        Node<T> currentNode = list.getFirst();

        while (currentNode.item().compareTo(key) != 0) {
            if(currentNode.next() == null) return;

            currentNode = currentNode.next();
        }

        newNode.previous(currentNode);
        newNode.next(currentNode.next());

        //check is not last node
        if (newNode.next() != null)
            newNode.next().previous(newNode);
        else
            list.setLast(newNode);

        currentNode.next(newNode);
    }

    @Override
    public void insertBefore(T key, T elem) {
        Node<T> newNode = new Node<>(elem);
        Node<T> currentNode = list.getFirst();

        while (currentNode.item().compareTo(key) != 0) {
            if(currentNode.next() == null) return;

            currentNode = currentNode.next();
        }

        newNode.next(currentNode);
        newNode.previous(currentNode.previous());

        //not first
        if(newNode.previous() != null)
            newNode.previous().next(newNode);
        else
            list.setFirst(newNode);

        currentNode.previous(newNode);
    }*/
}
