package com.denis.shuvalov.algo.trees.binary.seacrh;

import com.denis.shuvalov.algo.trees.binary.examples.BTreePrinter;

import java.util.Arrays;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.insert(20)
                .insert(10)
                .insert(30)
                .insert(8)
                .insert(12)
                .insert(13)
                .insert(9)
                .insert(6)
                .insert(5)
//                .insert(3)
                .insert(11)
//                .insert(35)
//                .insert(42)
//                .insert(43)
//                .insert(33)
                //.delete(10)
        ;

        BTreePrinter.printNode(tree.root);

        tree.traverse()/*.bfs()*/;

        System.out.println("12? : " + tree.contains(12));
        System.out.println("Minimum depth in tree: " + tree.minDepth());
        System.out.println("Maximum depth in tree: " + tree.maxDepth());
        System.out.println("Tree amplitude is: " + tree.amplitude());
        System.out.println("Max path sum: " + tree.sumMaxPath(tree.root));
        System.out.println("Longest path: " + tree.longestPath());
        System.out.println("Lowest common ancestor for 5 and 13: " + tree.lowestCommonAncestor(5, 13));


        //System.out.println(alphabetize("arka"));
    }

    static String alphabetize(String word) {
        byte[] bytes = word.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }
}
