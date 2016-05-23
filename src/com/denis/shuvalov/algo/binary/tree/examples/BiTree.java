package com.denis.shuvalov.algo.binary.tree.examples;

public class BiTree {
    private BiTreeNode root;

    public BiTreeNode find(int key) {
        System.out.println("--- Find ---");
        BiTreeNode current = root;

        while (current.getKey() != key) {
            System.out.println(current.getKey() + " > " + key);
            if (current.getKey() > key) {
                System.out.println("Yes. Search in left child");
                current = current.getLeftChild();
            } else {
                System.out.println("No. Search in right child");
                current = current.getRightChild();
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void insert(int id, double data) {
        System.out.println("--- Insert " + id + " ---");
        if (root == null) {
            System.out.println("Tree is empty, add as root");
            root = new BiTreeNode(id, data);
            return;
        }

        BiTreeNode parent;
        BiTreeNode current = root;
        while (true) {
            System.out.println(current.getKey() + " < " + id);
            if (current.getKey() < id) {
                System.out.println("Yes. Going to right child");
                parent = current;
                current = current.getRightChild();

                if (current == null) {
                    System.out.println("Right child is empty adding node");
                    current = new BiTreeNode(id, data);
                    parent.setRightChild(current);
                    break;
                }
            } else {
                System.out.println("No. Going to left child");
                parent = current;
                current = current.getLeftChild();

                if (current == null) {
                    System.out.println("Left child is empty adding node");
                    current = new BiTreeNode(id, data);
                    parent.setLeftChild(current);
                    break;
                }
            }
        }
    }

    public void delete(int id) {
        BiTreeNode current = root, parent = current;

        while (current.getKey() != id) {
            if (current.getKey() > id) {
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = current;
                current = current.getRightChild();
            }

            if (current == null) {
                System.out.println("--- Not Found ---");
                return;
            }
        }

        if (current == root) {
            System.out.println("--- Found and deleted (root) ---");
            root = null;
            return;
        }

        //leaf
        if (current.getRightChild() == null && current.getLeftChild() == null) {
            System.out.println("--- Found and deleted (leaf)---");
            if (parent.getLeftChild() == current) parent.setLeftChild(null);
            else parent.setRightChild(null);
            return;
        }
        // only left child exist
        else if (current.getRightChild() == null) {
            System.out.println("--- Found and deleted (assigned to parent's left)---");
            if (parent.getLeftChild() == current) parent.setLeftChild(current.getLeftChild());
            else parent.setRightChild(current.getLeftChild());
            return;
        } else if (current.getLeftChild() == null) {
            System.out.println("--- Found and deleted (assigned to parent's right)---");
            if (parent.getLeftChild() == current) parent.setLeftChild(current.getRightChild());
            else parent.setRightChild(current.getRightChild());
            return;
        }

        System.out.println("--- Node " + id + " has two successors ---");
        BiTreeNode successor = getSuccessor(current);
        System.out.println("parent = " + parent);
        System.out.println("current = " + current);
        System.out.println("successor = " + successor);

        if (current == root) root = successor;
        else if (parent.getRightChild() == current) {
            parent.setRightChild(successor);
            successor.setLeftChild(current.getLeftChild());
        } else {
            parent.setLeftChild(successor);
            successor.setLeftChild(current.getLeftChild());
        }

    }

    // Метод возвращает узел со следующим значением после node.
    // Для этого он сначала переходит к правому потомку, а затем
    // отслеживает цепочку левых потомков этого узла.
    private BiTreeNode getSuccessor(BiTreeNode node) {
        BiTreeNode successorParent = node;
        BiTreeNode successor = node;
        BiTreeNode current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        // Если преемник не является правым потомком, создать связи между узлами
        if (node.getRightChild() != successor) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public BiTreeNode minimum() {
        BiTreeNode current = root, last = current;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }

        return last;
    }

    public void preorder() {
        System.out.println("--- Pre order --- ");
        preorder0(root);
    }

    public void inOrder() {
        System.out.println("--- In order --- ");
        inOrder0(root);
    }

    public void postorder() {
        System.out.println("--- Post order --- ");
        postorder0(root);
    }

    private void inOrder0(BiTreeNode node) {
        if (node == null) return;
        inOrder0(node.getLeftChild());
        System.out.println("node = " + node);
        inOrder0(node.getRightChild());
    }

    private void preorder0(BiTreeNode node) {
        if (node == null) return;
        System.out.println("node = " + node);
        preorder0(node.getLeftChild());
        preorder0(node.getRightChild());
    }

    private void postorder0(BiTreeNode node) {
        if (node == null) return;
        postorder0(node.getLeftChild());
        postorder0(node.getRightChild());
        System.out.println("node = " + node);
    }

    public void display() {
        BTreePrinter.printNode(root);
    }
}
