package com.denis.shuvalov.algo.trees.tree_234.book;

class BookTree234 {
    private Node root = new Node();

    public void insert(long dValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent(); // Возврат уровнем выше

                curNode = getNextChild(curNode, dValue);
            }
            else if (curNode.isLeaf()) {
                break; // Если узел листовой, переход к вставке
            }
            else { // Узел не полный и не листовой; спуститься уровнем ниже
                curNode = getNextChild(curNode, dValue);
            }
        }

        curNode.insertItem(tempItem);
    }

    private Node getNextChild(Node theNode, long theValue) {
        int i;
        // Предполагается, что узел не пуст, не полон и не является листом
        int numItems = theNode.getNumItems();

        for (i = 0; i < numItems; i++) { // Для каждого элемента в узле
            if (theValue < theNode.getItem(i).dData) {
                return theNode.getChild(i); // Вернуть левого потомка
            }
        }

        return theNode.getChild(i);
    }

    private void split(Node thisNode) {
        // Предполагается, что узел полон
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        }
        else {
            parent = thisNode.getParent();
        }

        // Разбираемся с родителем
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--) {
            // Перемещение связей родителя
            Node temp = parent.disconnectChild(j);
            // На одного потомка вправо
            parent.connectChild(j + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level,
                                int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();
        // Вывод содержимого узла
        // Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
}
