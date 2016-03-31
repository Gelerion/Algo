package com.denis.shuvalov.algo.lists.iterator;

public class TestIterator {
    public static void main(String[] args) {
        NodeList<Integer> list = new NodeList<>();

        list.add(1);
        list.add(4);
        list.add(7);
        list.add(8);

        list.displayList();

        CustomListIterator<Integer> iterator = list.getIterator();

        Integer current = iterator.getCurrent();
        System.out.println("current = " + current);

        iterator.nextNode();
        Integer next = iterator.getCurrent();
        System.out.println("next = " + next);

        iterator.insertAfter(5);
        iterator.insertAfter(6);
        list.displayList();

    }
}
