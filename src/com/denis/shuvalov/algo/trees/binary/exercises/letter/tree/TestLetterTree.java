package com.denis.shuvalov.algo.trees.binary.exercises.letter.tree;

public class TestLetterTree {
    public static void main(String[] args) {
        LetterTree tree = new LetterTree();
        tree.addSentenceAnotherWay("ABCDEFGHKLMNOPQR");
        tree.display();

        System.out.println("======= First way =======");
        tree = new LetterTree();
        tree.addSentence("ABCD");
        tree.display();

    }
}
