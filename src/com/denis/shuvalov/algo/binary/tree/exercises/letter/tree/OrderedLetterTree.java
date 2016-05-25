package com.denis.shuvalov.algo.binary.tree.exercises.letter.tree;

import com.denis.shuvalov.algo.binary.tree.exercises.letter.tree.LetterTree.LetterNode;
import com.denis.shuvalov.algo.binary.tree.exercises.letter.tree.LetterTree.Printer;

public class OrderedLetterTree {
    LetterNode root;

    void add(String s) {
        root = insert(s.toCharArray(), 0);
    }

    /**
     * * If you think of the nodes as being numbered in the same order the letters are arranged, with 1 at the root,
     * then any node numbered n has a left child numbered 2*n and a right child numbered 2*n+1.
     * You might use a recursive routine that makes two children and then calls itself for each child.
     */
    private LetterNode insert(char[] chars, int index) {
        if (index > chars.length - 1) return null;

        LetterNode node = new LetterNode().setValue(chars[index]);
        node.setLeft(insert(chars, 2 * index + 1));
        node.setRight(insert(chars, 2 * index + 2));
        return node;
    }

    void display() {
        Printer.printNode(root);
    }

}
