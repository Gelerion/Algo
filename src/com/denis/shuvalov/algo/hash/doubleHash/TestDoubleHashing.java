package com.denis.shuvalov.algo.hash.doubleHash;

public class TestDoubleHashing {
    public static void main(String[] args) {
        DoubleHashing hashing = new DoubleHashing(23);

        hashing.insert(1);
        hashing.insert(38);
        hashing.insert(37);
        hashing.insert(16);
        hashing.insert(20);
        hashing.insert(3);
        hashing.insert(11);
        hashing.insert(24);
        hashing.insert(5);
        hashing.insert(16);

        System.out.println(hashing);

        hashing.find(24);
    }
}
