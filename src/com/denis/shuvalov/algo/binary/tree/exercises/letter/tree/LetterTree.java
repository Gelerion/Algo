package com.denis.shuvalov.algo.binary.tree.exercises.letter.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Каждая буква отображается в собственном узле. Дерево должно строиться
 * так, чтобы все узлы, содержащие буквы, были листовыми. Родительские узлы могут
 * содержать какой-нибудь символ, не являющийся буквой, например +. Проследите
 * за тем, чтобы каждый родительский узел имел ровно двух потомков. Неважно, если
 * дерево получится несбалансированным. Обратите внимание: созданное дерево не
 * является деревом поиска; в нем не существует быстрого способа найти заданный
 * узел.
 */
public class LetterTree {
    LetterNode root;

    public LetterTree() {
        root = new LetterNode().setValue('+');
    }

    /**
     * индекс левого потомка:
     * 2*index + 1
     * Индекс правого потомка:
     * 2*index + 2
     * Индекс родителя:
     * (index-1) / 2
     */
    public void addSentenceAnotherWay(String sentence) {
        LetterTree[] forest = new LetterTree[Math.round((float) sentence.length() / 2)];

        int capacity = sentence.length();
        int indx = 0;
        for (int i = 0; i < capacity / 2; i++) {
            forest[i] = new LetterTree();
            forest[i].root.left = new LetterNode().setValue(sentence.charAt(indx++));
            forest[i].root.right = new LetterNode().setValue(sentence.charAt(indx++));
        }

        if (capacity % 2 != 0) {
            int i = capacity / 2;
            forest[i] = new LetterTree();
            forest[i].root.left = new LetterNode().setValue(sentence.charAt(indx++));
        }

        int totalSuccessors = forest.length;

        root = combineTrees(Math.round((float) totalSuccessors / 2), forest, forest.length - 1).root;

    }

    private LetterTree combineTrees(int depth, LetterTree[] forest, int treeIndex) {
        if (depth == 1) {
            LetterTree result = new LetterTree();
            result.root.setLeft(forest[treeIndex--].root);
            if (treeIndex >= 0) result.root.setRight(forest[treeIndex].root);
            return result;
        }

        LetterTree[] tmp = new LetterTree[depth];
        for (int i = 0; i < depth; i++) {
            LetterTree current = new LetterTree();
            current.root.setRight(forest[treeIndex--].root);
            if (treeIndex >= 0) {
                current.root.setLeft(forest[treeIndex--].root);
            }
            tmp[i] = current;
        }

        int totalSuccessors = tmp.length;
        return combineTrees(Math.round((float) totalSuccessors / 2), tmp, tmp.length - 1);
    }

    public void addSentence(String sentence) {
        char[] chars = sentence.toCharArray();
        int capacity = chars.length - 1;
        int left = (int) Math.ceil((double) capacity / 2);
        int right = capacity - left;

        insert(root, chars, capacity);
    }

    private void insert(LetterNode node, char[] chars, int capacity) {
        if (capacity < 0) return;
        LetterNode newNode = new LetterNode().setValue(chars[capacity]);
        if (node.getLeft() == null && node.getRight() == null) {
            if (capacity % 2 == 0) node.setLeft(newNode);
            else node.setRight(newNode);
            insert(node, chars, --capacity);
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(new LetterNode().setValue('+'));
            node = node.getLeft();
            if (capacity % 2 == 0) node.setLeft(newNode);
            else node.setRight(newNode);
            insert(node, chars, --capacity);
        } else if (node.getRight() == null) {
            node.setRight(new LetterNode().setValue('+'));
            node = node.getRight();
            if (capacity % 2 == 0) node.setLeft(newNode);
            else node.setRight(newNode);
            insert(node, chars, --capacity);
        }
    }

    public void display() {
        Printer.printNode(root);
    }

    public void traverse(int order) {
        switch (order) {
            case 1:
                preorder();
                break;
            case 2:
                inOrder();
                break;
            case 3:
                postorder();
                break;
        }
    }

    private void preorder() {
        System.out.println("--- Pre order --- ");
        preorder0(root);
    }

    private void inOrder() {
        System.out.println("--- In order --- ");
        inOrder0(root);
    }

    private void postorder() {
        System.out.println("--- Post order --- ");
        postorder0(root);
    }

    private void inOrder0(LetterNode node) {
        if (node == null) return;
        inOrder0(node.getLeft());
        if (node.getValue() != '+') {
            System.out.println(node);
        }
        inOrder0(node.getRight());
    }

    private void preorder0(LetterNode node) {
        if (node == null) return;
        if (node.getValue() != '+') {
            System.out.println(node);
        }
        preorder0(node.getLeft());
        preorder0(node.getRight());
    }

    private void postorder0(LetterNode node) {
        if (node == null) return;
        postorder0(node.getLeft());
        postorder0(node.getRight());
        if (node.getValue() != '+') {
            System.out.println(node);
        }
    }

    static class LetterNode {
        private char value;
        private LetterNode left;
        private LetterNode right;

        public char getValue() {
            return value;
        }

        public LetterNode setValue(char value) {
            this.value = value;
            return this;
        }

        public LetterNode getLeft() {
            return left;
        }

        public LetterNode setLeft(LetterNode left) {
            this.left = left;
            return this;
        }

        public LetterNode getRight() {
            return right;
        }

        public LetterNode setRight(LetterNode right) {
            this.right = right;
            return this;
        }

        @Override
        public String toString() {
            return "Node {" + value + "}";
        }
    }

    static class Printer {
        public static void printNode(LetterNode root) {
            int maxLevel = Printer.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static void printNodeInternal(List<LetterNode> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || Printer.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            Printer.printWhitespaces(firstSpaces);

            List<LetterNode> newNodes = new ArrayList<>();
            for (LetterNode node : nodes) {
                if (node != null) {
                    System.out.print(node.getValue());
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                Printer.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    Printer.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        Printer.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        Printer.printWhitespaces(1);

                    Printer.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        Printer.printWhitespaces(1);

                    Printer.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static int maxLevel(LetterNode node) {
            if (node == null)
                return 0;

            return Math.max(Printer.maxLevel(node.getLeft()), Printer.maxLevel(node.getRight())) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
