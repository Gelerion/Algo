package com.denis.shuvalov.algo.adt.queue.array_based.test;


import com.denis.shuvalov.algo.adt.queue.AdtQueue;
import com.denis.shuvalov.algo.adt.queue.array_based.ArrayQueueSize;

public class TestArrayNoSize {
    public static void main(String[] args) {
        AdtQueue<Integer> queue = new ArrayQueueSize<>(10);

        System.out.println("=== Inset 1-2-3 elems ===");
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.display();
        System.out.println();

        System.out.println("=== Insert 4 to 10 elems ===");
        for (int i = 4; i <= 10; i++) {
            queue.insert(i);
        }
        queue.display();
        System.out.println();


        System.out.println("=== Remove first 3 elems ===");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();
        System.out.println();


        System.out.println("=== Inset 10-11-12 elems ===");
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.display();
        System.out.println();

    }
}
