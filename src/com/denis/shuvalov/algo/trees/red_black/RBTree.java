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
                    validateTree(currentNode, 0);
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
                    validateTree(currentNode, 0);
                    return;
                } else {
                    depth++;
                    currentNode = currentNode.getRight();
                    newest.setParent(currentNode);
                }
            }
        }
    }

    private void validateTree(RBNode<V> current, int iteration) {
        if (current == null) {
            System.out.println("\tTree is valid");
            return;
        }

        System.out.println("\t\tValidating tree, Current " + current);

        if (current == root) {
            if (current.getColor() == Color.RED) {
                System.out.println("\t\tRoot color isn't black, flipping");
                current.setColor(Color.BLACK);
            }

            System.out.println("\tTree is valid");
            return;
        }

        if (hasTwoChilds(current.getParent())) {
            System.out.println("\t\tParent " + current.getParent() + " has two childs");

            if (bothChildsRed(current.getParent())) {
                System.out.println("\t\tBoth childs are with Red color");

                if (iteration >= 1) {
                    System.out.println("ITERATION " + iteration);
//                    System.out.println("\t\tTree is valid");
                } else {
                    flipColorsWithChilds(current.getParent());
                    validateTree(current.getParent(), ++iteration);
                }
            } else {

                if (isRedParent(current)) {

                    if (current.getParent() == root) {
                        System.out.println("\t\tRoot is Red switching color");
                        doFlip(current.getParent());
                        validateTree(current.getParent(), ++iteration);
                        return;
                    }

                    if (current.getColor() == Color.BLACK) {
                        System.out.println("\tTree is valid");
                    } else {
                        System.out.println("\t\tOne Red child and one Black");

                        if (bothChildsRed(current.getParent().getParent())) {
                            System.out.println("\t\tGrandfather has two red childs: " + current.getParent().getParent() + " Parent " + current.getParent());
                            flipColorsWithChilds(current.getParent().getParent());
                            validateTree(current.getParent().getParent(), ++iteration);
                        } else {
                            System.out.println("\t\tTwo red nodes in a line Parent: " + current.getParent() + " Child " + current);
                            if (isLeftNode(current.getParent(), current)) {
                                System.out.println("\t\tCurrent node is left (outer) to his parent, rotating to right");
                                rotateToRight(current.getParent());
                                validateTree(current.getParent(), ++iteration);
                            }
                        }
                    }
                } else {
                    System.out.println("\t\tBoth childs are Black");
                    //black - red relations
                    validateTree(current.getParent(), ++iteration);
                }
            }
        } else if (current.getLeft() != null && current.getColor() == Color.RED) { //only one child
            System.out.println("\t\tCurrent and left child node are red");
            flipColorsWithChilds(current.getParent());
            rotateToRight(current);
            validateTree(current.getParent(), ++iteration);
        } else if (current.getRight() != null && current.getColor() == Color.RED) {
            System.out.println("\t\tCurrent and right child node are red");
            flipColorsWithChilds(current.getParent());
            rotateToLeft(current);
            validateTree(current.getParent(), ++iteration);
        }
    }

    private boolean parentNotRoot(RBNode<V> node) {
        return node == root;
    }

    private boolean isRedParent(RBNode<V> node) {
        return node.getParent() != null && node.getParent().getColor() == Color.RED;
    }

    private void flipColorsWithChilds(RBNode<V> node) {
        if (hasTwoChilds(node)) {
            System.out.println("\t\t\tFlipping colors for node with two childs with same colors");
            doFlip(node);
            doFlip(node.getLeft());
            doFlip(node.getRight());
        } else if (node.getLeft() != null) {
            System.out.println("\t\t\tFlipping colors for node with one left child");
            doFlip(node);
            doFlip(node.getLeft());
        } else {
            System.out.println("\t\t\tFlipping colors for node with one right child");
            doFlip(node);
            doFlip(node.getRight());
        }
    }

    //Early version
    private void checkCorrectness(RBNode<V> father, int depth, boolean isLeft) {
        if (depth == 0) {
            System.out.println("\t\tInserting after root -> correct\n");
        } else /*if(depth == 1)*/ {

            if (hasTwoChilds(father.getParent())) {
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
                    RBNode<V> grandFatherParent = grandFather.getParent();
                    System.out.println("Grand: " + grandFatherParent);
                    System.out.println("Father: " + grandFather);

                    if (bothChildsRed(grandFatherParent)) {
                        System.out.println("\t\t\tBoth childs are " + Color.RED + " flipping colors");
                        doFlip(grandFatherParent);
                        doFlip(grandFatherParent.getLeft());
                        doFlip(grandFatherParent.getRight());
                    }


                    if (grandFatherParent.getColor() == Color.RED && grandFather.getColor() == Color.RED) {
                        if (grandFatherParent.getLeft() == grandFather) { //left (outer) child
                            System.out.println("Both red, rotate to right");
                            rotateToRight(grandFatherParent);
                        }


                    }

//                    checkCorrectness(father.getParent(), depth - 1, isLeft);
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

    private boolean bothChildsRed(RBNode<V> node) {
        return node != null && node.getLeft().getColor() == Color.RED && node.getRight().getColor() == Color.RED;
    }

    private void rotateToRight(RBNode<V> node) {
        RBNode<V> parent = node.getParent();
        System.out.println("\t\t\tRotate " + parent + " to right");
        boolean isLeftSet = false;

        if (hasTwoChilds(node)) {
            RBNode<V> innerRightChild = node.getRight();
            RBNode<V> outerLeftCHild = node.getLeft();

            doFlip(node);
            doFlip(parent);

            parent.setLeft(innerRightChild);
            innerRightChild.setParent(parent);
            isLeftSet = true;
        }

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
        if (!isLeftSet) parent.setLeft(null);

        if (parent == root) {
            root = node.setParent(null);
            System.out.println("\t\t\tNew root " + node
                    + ", left node " + node.getLeft() + ", right node " + node.getRight());
        }

    }

    private void rotateToLeft(RBNode<V> node) {
        RBNode<V> parent = node.getParent();
        System.out.println("\t\t\tRotate " + parent + " to left");
    }

    private boolean isLeftNode(RBNode<V> parent, RBNode<V> child) {
        return parent.getLeft() == child;
    }

    private void flipColors(RBNode<V> node) {
        RBNode<V> parent = node.getParent();

        if (hasTwoChilds(parent)) {
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

    private boolean hasTwoChilds(RBNode<V> parent) {
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
