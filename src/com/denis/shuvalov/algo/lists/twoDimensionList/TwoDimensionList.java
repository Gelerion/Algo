package com.denis.shuvalov.algo.lists.twoDimensionList;

import com.denis.shuvalov.algo.lists.cyclicList.Node;

public class TwoDimensionList<T> {
    //    private TwoDimensionList<T> rows;
    private TwoDimensionList<TwoDimensionList<T>> columns;

    private Node<T> first;
    private Node<T> last;
    private int maxSize;

//    public TwoDimensionList(int rows, int columns) {
//        this.maxSize = columns;
//        for (int i = 0; i < maxSize; i++) {
//            columns.
//        }

//        this.rows = new TwoDimensionList<>(rows);
//        this.columns = new TwoDimensionList<>(columns);
    }

/*    private TwoDimensionList(int maxSize) {
        this.maxSize = maxSize;

        for (int i = 0; i < maxSize; i++) {
            mockList(i);
        }
    }

    private void mockList(int index, int rows) {
        TwoDimensionList<T> row = new TwoDimensionList<>(rows);
        Node<T> newNode = new Node<>(null);

        if (index == 0) last = newNode;
        else first.previous = newNode;

        newNode.next = first;
        first = newNode;
    }*/

/*
    public void insert(int row, int column, T elem) {
        Node<T> newElem = new Node<>(elem);

        Node<T> rowNode = rows.get(row);
        Node<T> columnNode = get(column);
        rows.insert(row, newElem);
        System.out.println("");
    }

    private void insert(int index, Node<T> elem) {
        Node<T> result = first;
        int current = 0;
        while (index != current) {
            result = first.next;
            current++;
        }

        elem.previous = result;
        elem.next = result.next;
        result.next.previous = elem;
        result.next = elem;
    }

    private Node<T> get(int index) {
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = first.next;
        }
        return result;
    }
    
    public void display() {
        StringBuilder header = new StringBuilder(rows.maxSize);
        header.append("X").append(" | ");
        for (int i = 0; i < rows.maxSize; i++) {
            header.append(i).append(" | ");
        }
//        header.append("\n");
        System.out.println(header);

        StringBuilder columnSb = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            columnSb.append(i).append(" | ");
            for (int j = 0; j < c.maxSize; j++) {
                if (rows.get(j) == null)
                    columnSb.append(rows.get(j)).append(" | ");
                else
                    columnSb.append('X').append(" | ");
            }
            columnSb.append("\n");
        }
        System.out.println(columnSb);
    } 
*/


