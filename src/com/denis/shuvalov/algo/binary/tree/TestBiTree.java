package com.denis.shuvalov.algo.binary.tree;

public class TestBiTree {
    public static void main(String[] args) {
        BiTree theTree = new BiTree(); // Создание дерева

        theTree.insert(50, 1.5);       // Вставка трех узлов
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        theTree.insert(80, 1.4);
        theTree.insert(22, 1.3);
        theTree.insert(24, 2.1);

        BiTreeNode found = theTree.find(24); // Поиск узла с ключом 25
        if (found != null) {
            System.out.println("Found the node with key 24");
            found.displayNode();
        } else {
            System.out.println("Could not find node with key 24");
        }

        theTree.preorder();
        theTree.inOrder();
        theTree.postorder();

        System.out.println("Minimum:" + theTree.minimum());
    }
}
