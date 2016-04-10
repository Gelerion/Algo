package com.denis.shuvalov.algo.lists.cyclicList;

import com.denis.shuvalov.algo.arrays.base.Log;

/**
 * A circular list is a linked list in which the last link points back to the first link.
 * There are many ways to design a circular list. Sometimes there is a pointer to
 * the “start” of the list. However, this makes the list less like a real circle and
 * more like an ordinary list that has its end attached to its beginning. Make a
 * class for a singly linked circular list that has no end and no beginning. The
 * only access to the list is a single reference, current, that can point to any link
 * on the list. This reference can move around the list as needed. (See
 * Programming Project 5.5 for a situation in which such a circular list is ideally
 * suited.) Your list should handle insertion, searching, and deletion. You may
 * find it convenient if these operations take place one link downstream of the
 * link pointed to by current. (Because the upstream link is singly linked, you
 * can’t get at it without going all the way around the circle.) You should also be
 * able to display the list (although you’ll need to break the circle at some arbitrary
 * point to print it on the screen). A step() method that moves current
 * along to the next link might come in handy too.
 */
public class CyclicLinkList {
    private Node<Integer> current;
    private int size;

    /**
     * insert value after current
     */
    public void insert(Integer value) {
        Node<Integer> newNode = new Node<>(value);
        if (isEmpty()) {
            newNode.previous = newNode;
            newNode.next = newNode;
        } else {
            current.next.previous = newNode;
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
        }

        current = newNode;
        size++;
    }

    public CyclicLinkList stepForward() {
        current = current.next;
        return this;
    }

    public CyclicLinkList stepBack() {
        current = current.previous;
        return this;
    }

    public int find(int key) {
        Node<Integer> tmp = this.current;
        int iterated = size;

        while (iterated != 0) {
            if (tmp.item.equals(key)) {
                Log.List.find.found(key);
                return tmp.item;
            }

            tmp = tmp.next;
            iterated--;
        }

        Log.List.find.notFound(key);
        return -1;
    }

    public int remove() {
        Integer result = current.item;
        Node<Integer> next = current.next;
        current.previous.next = next;
        next.previous = current.previous;
        current = null;
        current = next;
        size--;
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node<Integer> tmp = this.current;
        //iterating till first element
        for (int i = 0; i <= size; i++) {
            tmp = tmp.next;
        }

        for (int i = 0; i < size; i++) {
            if (i == size - 1) System.out.println(tmp);
            else System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }
    }
}
