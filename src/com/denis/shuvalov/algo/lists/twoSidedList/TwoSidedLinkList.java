package com.denis.shuvalov.algo.lists.twoSidedList;

import com.denis.shuvalov.algo.lists.Link;

/**
 * two sided means we have pointers to the first element and to the last
 */
public class TwoSidedLinkList {
    Link first;
    Link last;

    void insertFirst(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty()) {
            first = link;
            last = link;
            return;
        }

        Link tmp = first;
        first = link;
        first.next = tmp;
    }

    void bookInsertFirst(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty()) last = link;

        link.next = first;
        first = link;
    }

    void insertLast(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty()) {
            first = link;
            last = link;
        }
        else {
            last.next = link;
            last = link;
        }
    }

    void bookInsertLast(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty()) // Если список пуст,
            first = link; // first --> newLink
        else
            last.next = link; // Старое значение last --> newLink

        last = link; // newLink <-- last
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
        System.out.println("First: " + first);
        System.out.println("Last: " + last);
        System.out.println("-----------------");
        doDisplay();
    }

    private void doDisplay() {
        System.out.println(first);
        Link tmp = null;
        if (!isEmpty()) tmp = first.next;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

}
