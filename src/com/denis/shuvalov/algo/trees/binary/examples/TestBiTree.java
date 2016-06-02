package com.denis.shuvalov.algo.trees.binary.examples;

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

        theTree.display();
        System.out.println("Deleting key: 22");
        theTree.delete(24);
        theTree.display();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(" ======== Create new Tree  ======== ");
        theTree = new BiTree();
        theTree.insert(5, 1);
        theTree.insert(8, 11);
        theTree.insert(3, 2);
        theTree.insert(15, 3);
        theTree.insert(2, 4);
        theTree.insert(3, 4);
        theTree.insert(6, 4);
        theTree.insert(11, 5);
        theTree.insert(13, 5);
        theTree.insert(9, 5);
        theTree.insert(16, 5);
        theTree.insert(17, 5);
        theTree.display();

        theTree.delete(15);
//        System.out.println("Delete key : 55");
//        theTree.delete(55);
        theTree.display();
//
//        System.out.println("Delete key : 65");
//        theTree.delete(65);
//        theTree.display();
    }
}
