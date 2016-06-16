package com.denis.shuvalov.algo.trees.tree_234;

import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

class Tree234<T extends Comparable<T>> {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;

    private Node234<T> root = new Node234<>();

    void find(T elem) {
        Node234<T> current = root;
        doFind(current, elem);
    }

    private void doFind(Node234<T> node, T elem) {
        if (node == null) {
            System.out.println("Element not found");
            return;
        }


    }

    void insert(T elem) {
        Node234<T> current = root;
        doInsert(current, elem);
    }

    private void doInsert(Node234<T> node, T elem) {
        if (node.isFull()) {
            split(node);
            doInsert(advance(node.getParent(), elem), elem);
        }
        else if (node.isLeaf()) {
            node.add(elem);
        }
        else { // Узел не полный и не листовой; спуститься уровнем ниже
            doInsert(advance(node, elem), elem);
        }
    }

    private Node234<T> advance(Node234<T> node, T value) {
        int nextIndex;
        for (nextIndex = 0; nextIndex < node.getSize(); nextIndex++) {
            if (node.getValue(nextIndex).compareTo(value) >= 1)
                return node.getChild(nextIndex);
        }

        return node.getChild(nextIndex);
    }

    /**
     * - Создается новый пустой узел. Он является «братом» (одноуровневым узлом)
     * по отношению к разбиваемому узлу и размещается справа от него.
     * - Элемент данных C перемещается в новый узел.
     * - Элемент данных B перемещается в родителя разбиваемого узла.
     * - Элемент данных A остается на своем месте.
     * - Два правых потомка отсоединяются от разбиваемого узла и связываются с но-
     * вым узлом.
     */
    private void split(Node234<T> current) {
        Node234<T> parent;

        Node234<T> newRight = new Node234<>(current.removeValue(C))
                .addChild(FIRST, current.removeChild(THIRD))
                .addChild(SECOND, current.removeChild(FOURTH));

        if (current == root) {
            parent = new Node234<>();
            root = parent;
            parent.addChild(FIRST, current);
        }
        else {
            parent = current.getParent();
        }

        // Разбираемся с родителем
        int itemIndex = parent.add(current.removeValue(B));
        if (itemIndex == -1) throw new DuplicateFormatFlagsException("Duplicates not allowed");
        int elems = parent.getSize();

        // Перемещение связей родителя На одного потомка вправо
        for (int i = elems - 1; i > itemIndex; i--) {
            parent.addChild(i + 1, parent.removeChild(i));
        }

        parent.addChild(itemIndex + 1, newRight);
    }

    void display() {
        doDisplay(root, 0);
    }

    private void doDisplay(Node234<T> node, int depth) {
        if (node == null) return;

        if (depth == 0) {
            if (node.hasChildren()) System.out.println("Root: " + node + " Childs: " + Arrays.toString(node.children));
            else System.out.println("Root: " + root);
        }
        else {
            if (node.hasChildren())
                System.out.println("Depth#" + depth + ": " + node + " Childs: " + Arrays.toString(node.children));
            else System.out.println("Depth#" + depth + ": " + node);
        }

        depth++;
        for (Node234<T> child : node.children) {
            doDisplay(child, depth);
        }
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node234<T> thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        System.out.println(thisNode);
//         Вывод содержимого узла
//         Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getSize();
        for (int j = 0; j < numItems + 1; j++) {
            Node234<T> nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }

    private static class Node234<T extends Comparable<T>> {
        private static final int ORDER = 4;
        private Node234<T> parent;
        @SuppressWarnings("unchecked")
        private Node234<T>[] children = new Node234[ORDER];
        @SuppressWarnings("unchecked")
        private DataItem<T>[] items = new DataItem[ORDER - 1];
        private int size = -1;

        Node234() {
        }

        Node234(T value) {
            items[++size] = new DataItem<>(value);
        }

        int add(T elem) {
            DataItem<T>[] elements = this.items;

            if (!valid(elem, elements)) return -1;

            ++size;

            DataItem<T> newItem = new DataItem<>(elem);

            for (int i = ORDER - 2; i >= 0; i--) {
                if (elements[i] == null) continue;

                if (elements[i].getItem().compareTo(elem) >= 1) {
                    elements[i + 1] = elements[i];
                }
                else {
                    elements[i + 1] = newItem;
                    return i + 1;
                }
            }

            elements[0] = newItem;
            return 0;
        }

        private boolean valid(T value, DataItem<T>[] values) {
            if (this.isFull()) {
                System.out.println("[ERROR] Node is full can not insert! " + this + " Value: " + value);
                return false;
            }

            for (DataItem<T> item : values) {
                if (item != null && item.getItem().compareTo(value) == 0) {
                    System.out.println("[WARN] Duplicate value not allowed: " + this + " Value: " + value);
                    return false;
                }
            }
            return true;
        }

        Node234<T> addChild(int index, Node234<T> child) {
            children[index] = child;
            if (child != null) child.setParent(this);
            return this;
        }

        Node234<T> getParent() {
            return parent;
        }

        Node234<T> setParent(Node234<T> parent) {
            this.parent = parent;
            return this;
        }

        T getValue(int index) {
            if (index > size) return null;
            return items[index].getItem();
        }

        boolean hasChildren() {
            return children[0] != null;
        }

        boolean isFull() {
            return items[ORDER - 2] != null;
        }

        T removeValue(int index) {
            T result = items[index].getItem();
            items[index] = null;
            size--;
            return result;
        }

        Node234<T> removeChild(int index) {
            Node234<T> result = children[index];
            children[index] = null;
            return result;
        }

        Node234<T> getChild(int index) {
            return children[index];
        }

        public int getSize() {
            return size + 1;
        }

        int getItems() {
            return size;
        }

        @Override
        public String toString() {
            return "Node{" + Arrays.toString(items) + "}";
        }

        boolean isLeaf() {
            return !hasChildren();
        }
    }

    private static class DataItem<T extends Comparable<T>> {
        T item;

        DataItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public DataItem<T> setItem(T item) {
            this.item = item;
            return this;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

}

