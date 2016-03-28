package com.denis.shuvalov.algo.lists.sorted;

class SortedList {
    private Node first;

    public void insert(long value) {
        Node newValue = new Node(value);
        if (isEmpty()) {
            first = newValue;
            return;
        }

        Node node = this.first;
        long current = node.value;
        // current is bigger
        while (Long.compare(value, current) == 1) {
            if (node.next == null) {
                //insert last
                node.next = newValue;
                return;
            }
            node = node.next;
            value = node.value;
        }

        first = newValue;
        first.next = node;
    }

    long remove() {
        long value = first.value;
        first = first.next;
        return value;
    }

    public void display() {
        System.out.print(first + " -> ");
        Node tmp = null;
        if (!isEmpty()) tmp = first.next;
        while (tmp != null) {
            if (tmp.next == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }
    }

    boolean isEmpty() {
        return first == null;
    }

    private static class Node {
        long value;
        Node next;

        public Node(long value) {
            this.value = value;
        }

        public Node(long value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
