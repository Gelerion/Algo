package com.denis.shuvalov.algo.lists.simpleList;

public class CustomListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insertFirst(1, 1);
        list.insertFirst(2, 2);
        list.insertFirst(3, 3);
        list.insertFirst(4, 4);

//        list.display();

//        LinkList.Link link = list.find(2);
//        System.out.println(link);

        System.out.println("Deleted: " + list.delete(1));
        list.display();

    }

}
