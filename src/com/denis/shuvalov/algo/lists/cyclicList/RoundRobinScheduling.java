package com.denis.shuvalov.algo.lists.cyclicList;

/**
 * One of the most important roles of an operating system is in managing the many
 * processes that are currently active on a computer, including the scheduling of those
 * processes on one or more central processing units (CPUs). In order to support
 * the responsiveness of an arbitrary number of concurrent processes, most operating
 * systems allow processes to effectively share use of the CPUs, using some form of
 * an algorithm known as round-robin scheduling. A process is given a short turn
 * to execute, known as a time slice, but it is interrupted when the slice ends, even if
 * its job is not yet complete. Each active process is given its own time slice, taking
 * turns in a cyclic order. New processes can be added to the system, and processes
 * that complete their work can be removed.
 * <p>
 * A round-robin scheduler could be implemented with a traditional linked list, by
 * repeatedly performing the following steps on linked list L (see Figure 3.15):
 * 1. process p = L.removeFirst( )
 * 2. Give a time slice to process p
 * 3. L.addLast(p)
 */
public class RoundRobinScheduling<E> {

    private Node<E> tail;
    private int size;

    //addLast, rotate, first, last

    void addFirst(E elem) {
        if (isEmpty()) {
            tail = new Node<>(elem, null);
            tail.setNext(tail);
        }
        else {
            Node<E> newest = new Node<>(elem, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    void addLast(E elem) {
        addFirst(elem);
        tail = tail.getNext();
    }

    boolean isEmpty() {
        return size == 0;
    }

    E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) return null;

        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(tail.getNext());
        size--;
        return head.getElement();
    }

    /**
     * rotate(): Moves the first element to the end of the list.
     * With this new operation, round-robin scheduling can be efficiently implemented by
     * repeatedly performing the following steps on a circularly linked list C:
     * 1. Give a time slice to process C.first( )
     * 2. C.rotate( )
     */
    void rotate() {
        tail = tail.getNext();
    }


    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
