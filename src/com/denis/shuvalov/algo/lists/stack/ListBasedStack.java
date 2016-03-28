package com.denis.shuvalov.algo.lists.stack;

public class ListBasedStack {
    private Node current;

    public void push(String elem) {
        Node node = new Node(elem);
        node.next = current;
        current = node;
    }

    public String pop() {
        String value = current.value;
        current = current.next;
        return value;
    }

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }
}
