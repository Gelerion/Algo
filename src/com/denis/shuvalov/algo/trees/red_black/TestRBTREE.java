package com.denis.shuvalov.algo.trees.red_black;

import java.util.ArrayList;
import java.util.Random;

public class TestRBTREE {
    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();

        Random r = new Random();

        ArrayList<Integer> ints = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            int in = r.nextInt(120);
//            ints.add(in);
//            tree.insert(in);
//        }

        System.out.println("==============");
        System.out.println("Ins: " + ints);

//        Ins: [48, 63, 11, 10, 27, 77, 87, 14, 36, 35, 13, 59, 89, 23, 15]

//        Ins: [63, 14, 119, 40, 34, 15, 9, 39, 55, 42, 95, 72, 77, 103, 114] ERROR

        tree.insert(63);
        tree.insert(14);
        tree.insert(119);
        tree.insert(40);
        tree.insert(34);
        tree.insert(15);
        tree.insert(9);
        tree.insert(39);
        tree.insert(55);
        tree.insert(42);


//        tree.insert(200);
//        tree.insert(180);
//        tree.insert(160);
//        tree.insert(220);
//        tree.insert(230);
//        tree.insert(240);
//        tree.insert(250);
//        tree.insert(260);
//        tree.insert(270);
//        tree.insert(280);
//        tree.insert(290);
//        tree.insert(300);
//        tree.insert(310);
//        tree.insert(320);
//
//        tree.insert(150);
//
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

//        tree.insert(135);
//        tree.insert(136);
//        tree.insert(138);
//        tree.insert(137);

        tree.display();
    }
}
