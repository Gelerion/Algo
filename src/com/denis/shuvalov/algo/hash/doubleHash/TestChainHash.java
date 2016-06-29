package com.denis.shuvalov.algo.hash.doubleHash;

public class TestChainHash {
    public static void main(String[] args) {
        ChainHashing<Integer> hashing = new ChainHashing<>(10);

        hashing.insert(10);
        hashing.insert(20);
        hashing.insert(15);
        hashing.insert(18);
        hashing.insert(5);
        hashing.insert(25);
        hashing.insert(40);
        hashing.insert(33);
        hashing.display();
        hashing.insert(30);
        hashing.insert(13);
        hashing.insert(67);
        hashing.insert(66);
        hashing.insert(73);

        hashing.display();

        System.out.println(hashing.get(15));
        System.out.println(hashing.get(30));
        System.out.println(hashing.get(10));
        System.out.println("--- DELETING --");
        hashing.display();

        System.out.println("--- INSERT --");
        hashing.insert(11);
        hashing.insert(10);
        hashing.display();


    }
}
