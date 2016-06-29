package com.denis.shuvalov.algo.trees.tree_234;

public class TestTree234 {
    public static void main(String[] args) {
        Tree234<Integer> tree = new Tree234<>();
        tree.insert(70);
        tree.insert(50);
        tree.insert(30);
        tree.insert(40);

        tree.insert(20);
        tree.insert(80);

        tree.insert(25);

        tree.insert(90);
        tree.insert(100);
        tree.insert(110);
        tree.insert(120);
        tree.insert(130);
        tree.insert(140);
        tree.insert(150);
        tree.insert(34);
        tree.insert(26);

//        tree.display();
        tree.displayTree();

        System.out.println("=============== FIND ================");
        tree.find(142);
    }
}
