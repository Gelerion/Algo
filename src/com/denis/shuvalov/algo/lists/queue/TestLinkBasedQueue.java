package com.denis.shuvalov.algo.lists.queue;

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
