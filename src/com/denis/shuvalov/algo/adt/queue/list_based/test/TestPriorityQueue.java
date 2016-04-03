package com.denis.shuvalov.algo.adt.queue.list_based.test;

import com.denis.shuvalov.algo.adt.queue.list_based.ListBasedPriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        ListBasedPriorityQueue<Integer> queue = new ListBasedPriorityQueue<>();

        queue.insert(5);
        queue.insert(10);
        queue.insert(15);

        queue.display();

        System.out.println("Insert at the beginning");
        queue.insert(4);
        queue.insert(2);
        queue.insert(1);
        queue.insert(3);
        queue.display();

        System.out.println("Insert at the middle");
        queue.insert(7);
        queue.insert(6);
        queue.insert(8);
        queue.insert(9);
        queue.insert(11);
        queue.insert(14);
        queue.insert(13);
        queue.insert(12);
        queue.display();

        System.out.println("Insert at the end");
        queue.insert(16);
        queue.insert(18);
        queue.insert(17);
        queue.display();
    }
}
