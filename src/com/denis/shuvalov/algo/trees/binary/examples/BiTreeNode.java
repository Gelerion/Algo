package com.denis.shuvalov.algo.trees.binary.examples;

public class BiTreeNode {
    int key; // Данные, используемые в качестве ключа
    double data; // Другие данные
    BiTreeNode leftChild; // Левый потомок узла
    BiTreeNode rightChild; // Правый потомок узла

    public BiTreeNode() {
    }

    public BiTreeNode(int key, double data) {
        this.key = key;
        this.data = data;
    }

    public void displayNode() {
        System.out.println("Node {key: " + key + ", value: " + data + "}");
    }

    @Override
    public String toString() {
        return "Node {key: " + key + ", value: " + data + "}";
    }

    public int getKey() {
        return key;
    }

    public BiTreeNode setKey(int key) {
        this.key = key;
        return this;
    }

    public double getData() {
        return data;
    }

    public BiTreeNode setData(double data) {
        this.data = data;
        return this;
    }

    public BiTreeNode getLeftChild() {
        return leftChild;
    }

    public BiTreeNode setLeftChild(BiTreeNode leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BiTreeNode getRightChild() {
        return rightChild;
    }

    public BiTreeNode setRightChild(BiTreeNode rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
