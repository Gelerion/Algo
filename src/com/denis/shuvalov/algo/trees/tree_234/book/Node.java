package com.denis.shuvalov.algo.trees.tree_234.book;

import java.util.Arrays;

class Node {
    private static int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public int insertItem(DataItem newItem) {
        // Предполагается, что узел не пуст
        numItems++;
        long newKey = newItem.dData;

        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            }
            else {
                long itsKey = itemArray[j].dData;

                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                }
                else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }

        itemArray[0] = newItem;
        return 0;
    }

    // Удаление наибольшего элемента
    DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    // Метод отсоединяет потомка от узла и возвращает его
    Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    // Связывание узла с потомком
    void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) child.parent = this;
    }


    Node getChild(int childNum) { return childArray[childNum]; }

    Node getParent() { return parent; }

    boolean isLeaf() { return (childArray[0] == null) ? true : false; }

    int getNumItems() { return numItems; }

    // Получение объекта DataItem с заданным индексом
    DataItem getItem(int index) { return itemArray[index]; }

    boolean isFull() { return (numItems == ORDER - 1) ? true : false; }

    public void displayNode() {
        for (int j = 0; j < numItems; j++)
            itemArray[j].displayItem();
        System.out.println("/");
    }

    @Override
    public String toString() {
        return "Node{" + Arrays.toString(itemArray) +
                '}';
    }
}
