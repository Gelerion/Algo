package com.denis.shuvalov.algo.lists.iterator;

class NodeList<T extends Comparable<T>> implements CustomIterator<T> {
    private Node<T> first;
    private Node<T> last;

    //ads last
    void add(T item) {
        Node<T> node = new Node<>(item);

        if(isEmpty())
            first = node;
        else
            last.next(node);

        node.previous(last);
        last = node;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    Node<T> getFirst() {
        return first;
    }

    Node<T> getLast() {
        return last;
    }

    boolean isEmpty() {
        return first == null;
    }

    @Override
    public CustomListIterator<T> getIterator() {
        return new MyOwnIterator<>(this);
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.print("Forward:  " + first + " -> ");
        Node<T> tmp = first.next();
        while (tmp != null) {
            if (tmp.next() == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.next();
        }
    }
}
