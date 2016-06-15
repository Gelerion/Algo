package com.denis.shuvalov.algo.trees.tree_234;

import java.util.Arrays;

public class Tree234<T extends Comparable<T>> {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private Node234<T> root;


    void insert(T value) {

        if (root == null) {
            root = new Node234<>(value);
            return;
        }

        if (root.isLeaf() && root.size < 2) {
            root.add(value);
            return;
        }

        Node234<T> current = root;

        while (true) {
            if (current.isFull()) {
//                splitRoot(current);
                split(current).add(value);
                break;
            }

            if (current.isLeaf()) {
                current.add(value);
                break;
            }

            current = advance(current, value);
        }
    }

    private Node234<T> advance(Node234<T> node, T value) {
//        System.out.println("Node size: " + node.getSize());
        Node234<T> result = null;
        if (node.getSize() == 1) { //only one element

            if (node.getFirstItem().compareTo(value) >= 1) {
                result = node.getLoverThenFirstValueChild();
            }
            else if (node.getFirstItem().compareTo(value) <= 1) {
                result = node.getBiggerThanFirstAndLoverThenSecondValueChild();
            }
            else {
                System.out.println("[WARN] Duplicate value not allowed: " + node + " Value: " + value);
            }

        }

        return result;
    }

    /**
     * - Создается новый пустой узел. Он является «братом» (одноуровневым узлом)
     * по отношению к разбиваемому узлу и размещается справа от него.
     * - Элемент данных C перемещается в новый узел.
     * - Элемент данных B перемещается в родителя разбиваемого узла.
     * - Элемент данных A остается на своем месте.
     * - Два правых потомка отсоединяются от разбиваемого узла и связываются с но-
     * вым узлом.
     *
     * @return Node to insert
     */
    private Node234<T> split(Node234<T> node) {
        Node234<T> parent = node.getParent();

        if (parent == null) {
            parent = new Node234<>(node.removeValue(B));
        }
        else {
            parent.add(node.removeValue(B));
        }

        Node234<T> brother = new Node234<>(node.removeValue(C));

        parent.addChild(node).addChild(brother);
//        parent.childs[0] = node;
//        parent.childs[1] = brother;

//        node.setParent(parent);
//        brother.setParent(parent);

        if (node == root) {
            root = parent;
        }

        return node;
    }

    private void splitRoot(Node234<T> node) {
        if (node == root) {
            //Создается новый корневой узел, он становится родителем разбиваемого узла.
            Node234<T> newRoot = new Node234<>(node.removeValue(B)); //Элемент данных B перемещается в созданный корневой узел.
            //Создается второй новый узел, который становится «братом» разбиваемого узла.
            Node234<T> brother = new Node234<>(node.removeValue(C)); //Элемент данных C перемещается в созданного «брата».

            root = newRoot;
            node.setParent(newRoot);
            brother.setParent(root);

            root.addChild(node, 0);
            root.addChild(brother, 1);
        }
    }

    void display() {
        doDisplay(root, 0);
    }

    private void doDisplay(Node234<T> node, int depth) {
        if (node == null) return;

        if (depth == 0) {
            if (node.hasChilds()) System.out.println("Root: " + node + " Childs: " + Arrays.toString(node.childs));
            else System.out.println("Root: " + root);
        }
        else {
            if (node.hasChilds())
                System.out.println("Depth#" + depth + ": " + node + " Childs: " + Arrays.toString(node.childs));
            else System.out.println("Depth#" + depth + ": " + node);
        }

        depth++;
        for (Node234<T> child : node.childs) {
            doDisplay(child, depth);
        }
    }

    private static class Node234<T extends Comparable<T>> {
        private static final int ORDER = 4;
        private Node234<T> parent;
        @SuppressWarnings("unchecked")
        private Node234<T>[] childs = new Node234[ORDER];
        @SuppressWarnings("unchecked")
        private DataItem<T>[] items = new DataItem[ORDER - 1];
        private int size = -1;

        Node234(T value) {
            items[++size] = new DataItem<>(value);
        }

        Node234<T> add(T value) {
            DataItem<T>[] values = this.items;

            if (this.isFull()) {
                System.out.println("[ERROR] Node is full can not insert! " + this + " Value: " + value);
                return this;
            }

            for (DataItem<T> item : values) {
                if (item != null && item.getItem().compareTo(value) == 0) {
                    System.out.println("[WARN] Duplicate value not allowed: " + this + " Value: " + value);
                    return this;
                }
            }

            DataItem<T> current = values[A];
            if (current == null) {
                values[A] = new DataItem<>(value);
                ++size;
                return this;
            }

            if (values[A].getItem().compareTo(value) >= 1) { //current is bigger
                values[A] = new DataItem<>(value);
                DataItem<T> next = values[B];
                values[B] = current;
                values[C] = next;
                ++size;
                return this;
            }

            current = values[B];
            if (current == null) {
                values[B] = new DataItem<>(value);
                ++size;
                return this;
            }

            if (values[B].getItem().compareTo(value) >= 1) { //current is bigger
                DataItem<T> next = values[B];
                values[B] = new DataItem<>(value);
                values[C] = next;
                ++size;
                return this;
            }

            values[C] = new DataItem<>(value);
            ++size;
            return this;
        }

        T getFirstItem() {
            return items[A].item;
        }

        T getSecondItem() {
            return items[B].item;
        }

        T getThirdItem() {
            return items[C].item;
        }

        Node234<T> getLoverThenFirstValueChild() {
            return childs[0];
        }

        Node234<T> getBiggerThanFirstAndLoverThenSecondValueChild() {
            return childs[1];
        }

        Node234<T> getBiggerThanSecondAndLoverThenThirdValueChild() {
            return childs[2];
        }

        Node234<T> getBiggerThanThirdValueChild() {
            return childs[3];
        }

        Node234<T> addChild(Node234<T> child, int index) {
            childs[index] = child;
            return this;
        }

        Node234<T> addChild(Node234<T> child) {
            if (isAlreadyHaveThatChild(child)) {
                return this;
            }

            if (child.getSize() == 1) {
                for (int i = 0; i < items.length; i++) {
                    if (items[i] == null) {
                        this.childs[i] = child;
                        child.setParent(this);
                        break;
                    }

                    if (items[i].getItem().compareTo(child.getFirstItem()) >= 1) { //current is bigger
                        this.childs[i] = child;
                        child.setParent(this);
                        break;
                    }
                }
            }
            else {
                System.out.println("[BUGGG] addChild(Node234<T> child)");
            }
            return this;
        }

        private boolean isAlreadyHaveThatChild(Node234<T> child) {
            boolean result = false;
            for (int i = 0; i < childs.length; i++) {
                if (childs[i] != null) {
                    if (childs[i] == child) {
                        result = true;
                        break;
                    }
                }
            }
            return result;
        }

        Node234<T> getParent() {
            return parent;
        }

        Node234<T> setParent(Node234<T> parent) {
            this.parent = parent;
            return this;
        }

        Node234<T> setChilds(Node234<T>[] childs) {
            this.childs = childs;
            return this;
        }

        T getValue(int index) {
            if (index > size) return null;
            return items[index].getItem();
        }

        boolean hasChilds() {
            for (int i = 0; i < childs.length; i++) {
                if (childs[i] != null) {
                    return true;
                }
            }
            return false;
        }

        boolean isFull() {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    return false;
                }
            }
            return true;
        }

        T removeValue(int index) {
//            if (index > size) return null;
            T result = items[index].getItem();
            items[index] = null;
//            if(index == 0) {
//                items[0] = items[1];
//                items[1] = items[2];
//                items[2] = null;
//            }
//            else if(index == 1) {
//                items[1] = items[2];
//                items[2] = null;
//            }
            size--;
            return result;
        }

        public int getSize() {
            return size + 1;
        }

        @Override
        public String toString() {
            return "Node{" + Arrays.toString(items) + "}";
        }

        boolean isLeaf() {
            return !hasChilds();
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

