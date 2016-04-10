package com.denis.shuvalov.algo.lists.twoDimensionList;

import com.denis.shuvalov.algo.lists.cyclicList.Node;

public class TwoDimensionList<T> {
    private TwoDimensionList<T> row;
    private TwoDimensionList<T> column;

    private Node<T> first;
    private Node<T> last;
    private int maxSize;

    public TwoDimensionList(int rows, int columns) {
        this.row = new TwoDimensionList<>(rows);
        this.column = new TwoDimensionList<>(columns);
    }

    private TwoDimensionList(int maxSize) {
        this.maxSize = maxSize;

        for (int i = 0; i < maxSize; i++) {
            mockList(i);
        }
    }

    private void mockList(int index) {
        Node<T> newNode = new Node<>(null);

        if (index == 0) last = newNode;
        else first.previous = newNode;

        newNode.next = first;
        first = newNode;
    }

    public void insert(int row, int column, T elem) {
        Node<T> rowNode = getRowNode(row);
    }

    private Node<T> getRowNode(int index) {
        System.out.println(index);
        return null;
    }

}
