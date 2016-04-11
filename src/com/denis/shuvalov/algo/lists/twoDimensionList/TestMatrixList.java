package com.denis.shuvalov.algo.lists.twoDimensionList;

public class TestMatrixList {
    public static void main(String[] args) {
        MatrixList<String> list = new MatrixList<>(5, 6);
        list.insert(1, 4, "B");
        list.insert(0, 4, "A");
//        list.insert(2, 4, "C");

        list.display();
    }
}
