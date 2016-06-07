package com.denis.shuvalov.algo.trees.red_black;

public class TestRBTREE {
    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();

        tree.insert(200);
        tree.insert(180);
        tree.insert(160);
        tree.insert(220);
        tree.insert(230);


//        tree.insert(140);
//        tree.insert(130);
//        tree.insert(120);
//        tree.insert(110);
//        tree.insert(100);
//        tree.insert(90);
//        tree.insert(80);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(50);
//        tree.insert(40);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(10);
//        tree.insert(5);
//        tree.insert(4);
//        tree.insert(3);
//        tree.insert(2);
//        tree.insert(1);


        tree.display();
    }
}
