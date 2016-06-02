package com.denis.shuvalov.algo.trees.red_black;

public class RBTree<V extends Comparable<V>> {
    private RBNode<V> root;

    void display() {
        RBTreePrinter.printNode(root);
    }

    void insert(V value) {
        RBNode<V> newest = new RBNode<>(value, Color.RED);
        System.out.println("=== Start inserting " + newest + "===");

        if (root == null) {
            root = newest.setColor(Color.BLACK);
            System.out.println("-- Inserted as root (" + value + "), Color: Black --\n");
            return;
        }

        RBNode<V> currentNode = this.root;
        int depth = 0;

        while (true) {
            V currentValue = currentNode.getValue();

//          (x < y) ? -1 : ((x == y) ? 0 : 1);
            System.out.println(" - Check " + currentValue + " < " + value + " Depth: " + depth);
            if (currentValue.compareTo(value) > 0) {
                System.out.println("\tNo. Going to left child");

                if (currentNode.getLeft() == null) {
                    System.out.println("\t\tLeft child is empty adding node");
                    currentNode.setLeft(newest);
                    newest.setParent(currentNode);
                    checkCorrectness(currentNode, depth, true);
                    return;
                } else {
                    depth++;
                    currentNode = currentNode.getLeft();
                }

            } else {
                System.out.println("\tYes. Going to right child");

                if (currentNode.getRight() == null) {
                    System.out.println("\t\tRight child is empty adding node");
                    currentNode.setRight(newest);
                    return;
                } else {
                    depth++;
                    currentNode = currentNode.getRight();
                    newest.setParent(currentNode);
                }
            }
        }
    }

    private void checkCorrectness(RBNode<V> father, int depth, boolean isLeft) {
        if (depth == 0) {
            System.out.println("\t\tInserting after root -> correct\n");
        } else /*if(depth == 1)*/ {

            if (haveTwoChilds(father.getParent())) {
                System.out.println("\t\tFather " + father + " have two childs");

                flipColors(father);
                RBNode<V> grandFather = father.getParent();

                if (grandFather == root) {
                    if (grandFather.getColor() == Color.RED) {
                        System.out.println("\t\tRoot flipped color, changing to be " + Color.BLACK);
                        grandFather.setColor(Color.BLACK);
                        System.out.println("\t\tInserting new node -> correct\n");
                    } else {
                        //TODO: still black?
                        System.out.println("STILL BLACK BUG?");
                    }
                } else {
                    System.out.println("NOT ROOT CHECK IF CORRECT");
                }
            } else {
                if (father.getColor() == Color.RED) {
                    System.out.println("\t\tParent have one child with RED color");
                    flipColors(father);

                    //outer
                    if (isLeft) {
                        rotateToRight(father);
                        System.out.println("\t\tInserting new node -> correct\n");
                    }
                }
            }
        }
    }

    private void rotateToRight(RBNode<V> node) {
        RBNode<V> parent = node.getParent();
        System.out.println("\t\t\tRotate " + parent + " to right");

        node.setRight(parent);

        if (parent.getParent() != null) {
            RBNode<V> grand = parent.getParent();
            System.out.println("\t\t\tChanging references to the parent " + grand);
            node.setParent(grand);

            if (isLeftNode(grand, parent)) {
                System.out.println("\t\t\t\tSet left child to " + node);
                grand.setLeft(node);
            } else {
                System.out.println("\t\t\t\tSet right child to " + node);
                grand.setRight(node);
            }
        }

        parent.setParent(node);
        //TODO: possible bug?
        parent.setLeft(null);

        if (parent == root) {
            root = node.setParent(null);
            System.out.println("\t\t\tNew root " + node
                    + ", left node " + node.getLeft() + ", right node " + node.getRight());
        }

    }

    private boolean isLeftNode(RBNode<V> parent, RBNode<V> child) {
        return parent.getLeft() == child;
    }

    private void flipColors(RBNode<V> node) {
        RBNode<V> parent = node.getParent();

        if (haveTwoChilds(parent)) {
            RBNode<V> parentsLeft = parent.getLeft();
            RBNode<V> parentsRight = parent.getRight();

            //TODO only one RED
            if (parentsLeft.getColor() == Color.RED && parentsRight.getColor() == Color.RED) {
                System.out.println("\t\t\tBoth childs are " + Color.RED + " flipping colors");
                doFlip(parent);
                doFlip(parentsLeft);
                doFlip(parentsRight);
            }
        } else {
            doFlip(node);
            doFlip(node.getParent());
        }
    }

    private boolean haveTwoChilds(RBNode<V> parent) {
        return parent.getLeft() != null && parent.getRight() != null;
    }

    private void doFlip(RBNode<V> node) {
        Color color = node.getColor();
        color = color == Color.RED ? Color.BLACK : Color.RED;
        System.out.println("\t\t\t\t" + node + " switch color to " + color);
        node.setColor(color);
    }


    public enum Color {
        RED, BLACK
    }

    public static class RBNode<V extends Comparable<V>> {
        private V value;
        private Color color;
        private RBNode<V> parent;
        private RBNode<V> left;
        private RBNode<V> right;

        public RBNode(V value) {
            this.value = value;
        }

        public RBNode(V value, Color color) {
            this.value = value;
            this.color = color;
        }

        public V getValue() {
            return value;
        }

        public RBNode setValue(V value) {
            this.value = value;
            return this;
        }

        public Color getColor() {
            return color;
        }

        public RBNode<V> setColor(Color color) {
            this.color = color;
            return this;
        }

        public RBNode<V> getLeft() {
            return left;
        }

        public RBNode setLeft(RBNode<V> left) {
            this.left = left;
            return this;
        }

        public RBNode<V> getRight() {
            return right;
        }

        public RBNode setRight(RBNode<V> right) {
            this.right = right;
            return this;
        }

        public RBNode<V> getParent() {
            return parent;
        }

        public RBNode<V> setParent(RBNode<V> parent) {
            this.parent = parent;
            return this;
        }

        @Override
        public String toString() {
            return "Node{value: " + value + ", Color: " + color + "}";
        }
    }
}
