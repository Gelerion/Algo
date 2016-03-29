package com.denis.shuvalov.algo.lists.doubly;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

/*        list.insertFirst(15);
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

        //1 -> 2 -> 5 -> 10 -> 11 -> 15 -> 20 -> 21
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();

        //10 -> 11 -> 15 -> 20 -> 21
        list.deleteLast();
        list.deleteLast();

        //10 -> 11 -> 15
        list.deleteKey(11);

        //10 -> 15
        list.displayForward();
        list.displayBackward();*/

        list.insertFirst(22); // Вставка в начале
        list.insertFirst(44);
        list.insertFirst(66);
        list.insertLast(11); // Вставка в конце
        list.insertLast(33);
        list.insertLast(55);
        list.displayForward(); // Вывод в прямом направлении
        list.displayBackward(); // Вывод в обратном направлении
        list.deleteFirst(); // Удаление первого элемента
        list.deleteLast(); // Удаление последнего элемента
        list.deleteKey(11); // Удаление элемента с ключом 11
        list.displayForward(); // Вывод в прямом направлении
        list.insertAfter(22, 77); // Вставка 77 после 22
        list.insertAfter(33, 88); // Вставка 88 после 33
        list.displayForward();

    }
}
