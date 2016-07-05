package com.denis.shuvalov.algo.heap;

public class TestHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(12);
        heap.insert(8);
        heap.insert(15);
        heap.insert(18);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.display();
    }
}
