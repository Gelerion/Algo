package com.denis.shuvalov.algo.trees.red_black;

import com.denis.shuvalov.algo.trees.red_black.RBTree.RBNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.denis.shuvalov.algo.trees.red_black.RBTree.Color.RED;

public class RBTreePrinter {
    public static void printNode(RBNode root) {
        int maxLevel = RBTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<RBNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || RBTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        RBTreePrinter.printWhitespaces(firstSpaces);

        List<RBNode> newNodes = new ArrayList<>();
        for (RBNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue() + ":" + (node.getColor() == RED ? "R" : "B"));
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            RBTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                RBTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    RBTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    RBTreePrinter.printWhitespaces(1);

                RBTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    RBTreePrinter.printWhitespaces(1);

                RBTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(RBNode node) {
        if (node == null)
            return 0;

        return Math.max(RBTreePrinter.maxLevel(node.getLeft()), RBTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
