package com.denis.shuvalov.algo.trees.red_black;

public class TestRBTREE {
    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();

        tree.insert(200);
        tree.insert(180);
        tree.insert(160);
        tree.insert(140);
        tree.insert(130);
        tree.insert(120);
        tree.insert(110);
        tree.insert(100);

        tree.display();
    }
}
