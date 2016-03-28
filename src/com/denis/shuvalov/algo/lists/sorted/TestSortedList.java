package com.denis.shuvalov.algo.lists.sorted;

public class TestSortedList {
    public static void main(String[] args) {
        SortedList list = new SortedList();

        list.insert(20);
        list.insert(40);
        list.insert(10);
        list.insert(50);
        list.insert(60);
        list.insert(5);

        list.display();

        list.remove();
        list.remove();

        list.display();


    }
}
