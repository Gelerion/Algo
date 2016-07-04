package com.denis.shuvalov.algo.hash.tree;

public class TreeHashing {
    private Tree[] table;
    private int capacity;

    public TreeHashing(int capacity) {
        table = new Tree[capacity];
        this.capacity = capacity;
    }

    void add(int value) {
        int hash = hash(value);
        if (table[hash] == null) table[hash] = new Tree();
        table[hash].insert(value);
    }

    //Свертка
    private int hash(int v) {
        return (31 * v) % capacity;
    }

    private static class Tree {
        HashingNode root;

        void insert(int e) {
            HashingNode newest = new HashingNode(e);
            if (isEmpty()) {
                root = newest;
                return;
            }
            doInsert(root, e);
        }

        private void doInsert(HashingNode node, int e) {
            if (node.isLeaf()) {
                if (node.getValue() > e) link(node, e, true);
                else link(node, e, false);

                return;
            }


            if (node.getValue() > e) {

                if (node.getLeft() == null) {
                    link(node, e, true);
                    return;
                }

                doInsert(node.getLeft(), e);
            }
            else {

                if (node.getRight() == null) {
                    link(node, e, false);
                    return;
                }

                doInsert(node.getRight(), e);
            }
        }

        private void link(HashingNode node, int e, boolean isLeft) {
            HashingNode newest = new HashingNode(e);
            newest.setParent(node);
            if (isLeft) node.setLeft(newest);
            else node.setRight(newest);
        }

        int delete(int e) {
            return -1;
        }

        int find(int e) {
            return -1;
        }

        boolean isEmpty() {
            return root == null;
        }
    }

    private static class HashingNode {
        private int value;
        private HashingNode parent;
        private HashingNode left;
        private HashingNode right;

        private HashingNode(int value) {
            this.value = value;
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }

        private int getValue() {
            return value;
        }

        private HashingNode setValue(int value) {
            this.value = value;
            return this;
        }

        private HashingNode getLeft() {
            return left;
        }

        private HashingNode setLeft(HashingNode left) {
            this.left = left;
            return this;
        }

        private HashingNode getRight() {
            return right;
        }

        private HashingNode setRight(HashingNode right) {
            this.right = right;
            return this;
        }

        private HashingNode getParent() {
            return parent;
        }

        private HashingNode setParent(HashingNode parent) {
            this.parent = parent;
            return this;
        }
    }

}
