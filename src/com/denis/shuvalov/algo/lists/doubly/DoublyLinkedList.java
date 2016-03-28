package com.denis.shuvalov.algo.lists.doubly;

//225
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
        Node<T> nextNode = currentNode.next;

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

        if(currentNode == last) {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
            return true;
        }

        return false;

    }

    @Override
    public T deleteFirst() {
        return null;
    }

    @Override
    public T deleteLast() {
        return null;
    }

    @Override
    public T deleteKey(T elem) {
        return null;
    }

    @Override
    public void displayForward() {
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
