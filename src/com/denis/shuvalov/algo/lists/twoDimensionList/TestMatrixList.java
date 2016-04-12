package com.denis.shuvalov.algo.lists.twoDimensionList;

public class TestMatrixList {
    public static void main(String[] args) {
        MatrixList<String> list = new MatrixList<>(5, 6);
        list.insert(1, 4, "B");
        list.insert(0, 4, "A");
        list.insert(2, 4, "C");
        list.insert(1, 2, "R");

        list.display();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.insert(i, j, i + "," + j);
            }
        }
        list.display();


    }
}
