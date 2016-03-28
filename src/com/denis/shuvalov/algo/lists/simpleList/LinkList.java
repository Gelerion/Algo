package com.denis.shuvalov.algo.lists.simpleList;

import com.denis.shuvalov.algo.lists.Link;

class LinkList {
    private Link first;

    LinkList() {
    }

    void insertFirst(int key, double value) {
        Link link = new Link(key, value);
        if (!isEmpty()) link.next = first;
        this.first = link;
    }

    Link deleteFirst() {
        Link result = this.first;
        if (!isEmpty()) this.first = this.first.next;
        else first = null;
        return result;
    }

    Link find(int key) {
        Link current = first;
        while (current.key != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }

        return current;
    }

    Link delete(int key) {
        Link current = first;
        Link previous = null;

        while (current.key != key) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }

        if (previous != null) {
            previous.next = current.next;
        } else {
            first = first.next;
        }
        return current;

    }

    boolean isEmpty() {
        return first == null;
    }

    public void display() {
        System.out.println(first);
        Link tmp = null;
        if (!isEmpty()) tmp = first.next;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
}
