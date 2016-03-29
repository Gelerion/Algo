package com.denis.shuvalov.algo.lists.doubly;

class DoublyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private Node<T> first;
    private Node<T> last;

    @Override
    public void insertFirst(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (isEmpty())
            last = newNode;
        else
            first.previous = newNode;

        newNode.next = first;
        first = newNode;
    }

    @Override
    public void insertLast(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (isEmpty())
            first = newNode;
        else
            last.next = newNode;

        newNode.previous = last;
        last = newNode;

    }

    @Override
    public boolean insertAfter(T key, T elem) {
        Node<T> newNode = new Node<>(elem);

        Node<T> currentNode = first;
        Node<T> nextNode    = currentNode.next;

        while (nextNode != null) {
            if (currentNode.value.compareTo(key) == 0) {
                newNode.previous = currentNode;
                currentNode.next = newNode;

                newNode.next = nextNode;
                nextNode.previous = newNode;
                return true;
            }

            currentNode = nextNode;
            nextNode = currentNode.next;
        }

        if (currentNode == last) {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
            return true;
        }

        return false;

    }

    @Override
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }

        T result = first.value;

        if (first.next == null) {
            last = null;
            first = null;
        }
        else {
            first.next.previous = null;
            first = first.next;
        }

        return result;
    }

    @Override
    public T deleteLast() {
        if (isEmpty())
            return null;

        T value = last.value;

        if (last.previous == null) {
            last = null;
            first = null;
        }
        else {
            last.previous.next = null;
            last = last.previous;
        }

        return value;
    }

    @Override
    public T deleteKey(T elem) {
        if (isEmpty())
            return null;

        Node<T> current = this.first;
        while (current.value.compareTo(elem) != 0) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first)
            first = first.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = last.previous;
        else
            current.next.previous = current.previous;

        return current.value;
    }

    @Override
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.print("Forward:  " + first + " -> ");
        Node<T> tmp = first.next;
        while (tmp != null) {
            if (tmp.next == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }
    }

    @Override
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.print("Backward: " + last + " -> ");
        Node<T> tmp = last.previous;
        while (tmp != null) {
            if (tmp.previous == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.previous;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

     private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        Node(T value) {
            this.value = value;
        }

        Node(Node<T> previous, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
