package com.denis.shuvalov.algo.adt.queue.list_based.test;

import com.denis.shuvalov.algo.adt.queue.list_based.LinkBasedQueue;

public class TestLinkBasedQueue {
    public static void main(String[] args) {
        LinkBasedQueue queue = new LinkBasedQueue();

        queue.add("5");
        queue.add("4");
        queue.add("3");
        queue.add("2");

        System.out.println(queue.get());
    }
}
