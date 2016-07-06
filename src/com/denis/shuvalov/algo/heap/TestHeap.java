package com.denis.shuvalov.algo.heap;

public class TestHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);

//        100 90 80 30 60 50 70 20 10 40

        heap.insert(90);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(60);
        heap.insert(50);
        heap.insert(70);
        heap.insert(20);
        heap.insert(10);
        heap.insert(40);

        heap.display();

        System.out.print("Removed: ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.println();

        heap.display();

    }
}
