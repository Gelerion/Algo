package com.denis.shuvalov.algo.adt.queue.list_based.test;

import com.denis.shuvalov.algo.adt.queue.list_based.LinkBasedDeque;

public class TestListBasedDeque {
    public static void main(String[] args) {
        LinkBasedDeque<Integer> deque = new LinkBasedDeque<>();

        System.out.println("====Insert elements from left===");
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.display();

        System.out.println("====Remove 2 elements from left===");
        deque.removeLeft();
        deque.removeLeft();
        deque.display();

        System.out.println("====Insert elements from right===");
        deque.insertRight(2);
        deque.insertRight(3);
        deque.display();

        System.out.println("====Remove 2 elements from right===");
        deque.removeRight();
        deque.removeRight();
        deque.display();

        deque.removeRight();
        deque.removeRight();
        deque.removeLeft();
        deque.display();

        deque.insertLeft(1);
        deque.insertRight(2);
        deque.insertLeft(0);
        deque.insertRight(3);
        deque.display();

        deque.removeRight();
        deque.removeLeft();
        deque.display();




    }
}
