package com.denis.shuvalov.algo.adt.positionList.list;

import com.denis.shuvalov.algo.adt.positionList.Position;

public class PositionListTest {
    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(4);
        System.out.println("list = " + list);

        Position<Integer> cursor = list.first();
        while (cursor != null) {
            System.out.println(cursor.getElement());
            cursor = list.after(cursor);
        }

    }
}
