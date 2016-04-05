package com.denis.shuvalov.algo.lists.cyclicList;

public class TestCyclicLinkList {
    public static void main(String[] args) {
        CyclicLinkList list = new CyclicLinkList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.stepForward().stepForward();
        list.display();

        list.find(5);
        int remove = list.remove();
        System.out.println("remove = " + remove);
        list.display();
    }
}
