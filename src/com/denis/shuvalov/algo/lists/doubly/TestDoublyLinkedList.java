package com.denis.shuvalov.algo.lists.doubly;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insertFirst(15);
        list.insertFirst(10);
        list.insertFirst(5);
        list.insertFirst(1);

        list.insertLast(20);
        list.insertAfter(1, 2);
        list.insertAfter(10, 11);
        list.insertAfter(20, 21);

        list.displayForward();
        list.displayBackward();

        System.out.println("================= DELETE ================ ");
    }
}
