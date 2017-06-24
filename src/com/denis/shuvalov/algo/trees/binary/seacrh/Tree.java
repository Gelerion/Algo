package com.denis.shuvalov.algo.trees.binary.seacrh;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<V extends Comparable<V>> {
    TreeNode<V> root;

    //minimum depth in binary tree
    int minDepth() {
        if(root == null) return 0;
        return getMinRec(root, 0);
    }

    //maximum depth in binary tree
    int maxDepth() {
        if(root == null) return 0;
        return getMaxRec(root);
    }

    int amplitude() {
        return maxDepth() - minDepth();
    }

//    2. Max path through Left Child + Node
//    3. Max path through Right Child + Node
//    4. Max path through Left Child + Node + Max path through Right Child
    int sumMaxPath(TreeNode<? extends Integer> node) {
        Helper helper = new Helper();
        sumMaxPath(node, helper);
        return helper.val;
    }

    TreeNode<V> lowestCommonAncestor(V n1, V n2) {
        return lowestCommonAncestor(root, n1, n2);
    }

    private TreeNode<V> lowestCommonAncestor(TreeNode<V> node, V n1, V n2) {
        if(node == null) return null;

        //(x < y) ? -1 : ((x == y) ? 0 : 1)
        if(node.value().compareTo(n1) > 0 && node.value().compareTo(n2) > 0)
            return lowestCommonAncestor(node.leftChild(), n1, n2);

        if(node.value().compareTo(n1) < 0 && node.value().compareTo(n2) < 0)
            return lowestCommonAncestor(node.rightChild(), n1, n2);


        return node;
    }

    int longestPathBetweenTwoLeafs() {
        return 0;
    }

    int longestPath() {
        Helper helper = new Helper();
        findLongestPath(root, helper);
        return helper.val;
    }

    private int findLongestPath(TreeNode<V> node, Helper helper) {
        if(node == null) return 0;

        int l = findLongestPath(node.leftChild(), helper);
        int r = findLongestPath(node.rightChild(), helper);

        int currentLongest = l + r + 1;
        int oneSideMax = Math.max(l, r) + 1;
        if(helper.val < currentLongest) {
            //System.out.println("Chosen as longest: " + node + " v: " + currentLongest);
            helper.val = currentLongest;
        }

        return oneSideMax;
    }

    //maximum path sum
    //http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    int sumMaxPath(TreeNode<? extends Integer> node, Helper helper) {
        if(node == null) return 0;

        //find left max sum
        int l = sumMaxPath(node.leftChild(), helper);
        //find right max sum
        int r = sumMaxPath(node.rightChild(), helper);

        int maxSingle = Math.max(Math.max(l, r) + node.value(), node.value()); //maybe childs are less than zero
        int maxTop = Math.max(maxSingle, l + r + node.value());

        helper.val =  Math.max(helper.val, maxTop);
        return maxSingle;

    }

    private static class Helper {
        int val;
        public String toString() {return String.valueOf(val); }
    }

    Tree<V> insert(V newValue) {
        if(root == null) {
            root = TreeNode.root(newValue);
            return this;
        }

        TreeNode<V> current = root;
        while (true) {
            //(x < y) ? -1 : ((x == y) ? 0 : 1)
            int order = current.value().compareTo(newValue);
            if(order == 0) return this; //already in tree

            if (order > 0) {
                if (current.left == null) {
                    current.addLeft(TreeNode.leaf(newValue, current));
                    return this;
                }
                //go down
                current = current.left;
            }
            else {
                if(current.right == null) {
                    current.addRight(TreeNode.leaf(newValue, current));
                    return this;
                }

                current = current.right;
            }
        }
    }

    Tree<V> delete(V value) {
        if(root == null) return this;

        TreeNode<V> current = root;
        while (current != null) {
            int order = current.value().compareTo(value);
            if(order == 0) {
                doDelete(current);
                return this;
            }

            if(order > 0) current = current.left;
            else current = current.right;
        }

        return this;
    }

    private void doDelete(TreeNode<V> node) {
        if(node.isLeaf()) {
            TreeNode<V> parent = node.parent;
            parent.remove(node);
            return;
        }

        if(node.hasOnlyLeftChild()) {
            TreeNode<V> parent = node.parent;
            TreeNode<V> leftNode = node.left;
            parent.replaceChildWith(node, leftNode);
            return;
        }

        if(node.hasOnlyRightChild()) {
            TreeNode<V> parent = node.parent;
            TreeNode<V> rightNode = node.right;
            parent.replaceChildWith(node, rightNode);
            return;
        }

        // has both, get the leftmost successor from the right node
        TreeNode<V> successor = getSuccessor(node);
        node.parent.replaceChildWith(node, successor);
        successor.left = node.left;
        successor.left.parent = successor;
        successor.right = node.right;
    }

    private int getMaxRec(TreeNode<V> node) {
        if(node == null) return 0;
        return Math.max(
                getMaxRec(node.leftChild()),
                getMaxRec(node.rightChild())) + 1;
    }

    private int getMinRec(TreeNode<V> node, int currentDepth) {
        if(node == null) return currentDepth/* - 1*/;

        int lMin = getMinRec(node.leftChild(), currentDepth + 1);
        int rMin = getMinRec(node.rightChild(), currentDepth + 1);

        if (node.hasBothChilds()) {
            return Math.min(lMin, rMin);
        }
        else if (node.hasOnlyRightChild()) {
            return rMin;
        }
        else {
            return lMin;
        }
    }

    private TreeNode<V> getSuccessor(TreeNode<V> node) {
        TreeNode<V> successorParent = node;
        TreeNode<V> successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
            successorParent = successor;
        }

        successorParent.left = null;
        return successor;
    }

    boolean contains(V value) {
        if(root == null) return false;

        TreeNode<V> current = root;
        while (current != null) {
            int order = current.value().compareTo(value);
            if(order == 0) return true; //found

            if(order > 0) current = current.left;
            else current = current.right;

        }

        return false;
    }

    Tree<V> bfs() {
        System.out.println("BFS");
        if(root == null) {
            System.out.println("Empty");
            return this;
        }

        Queue<TreeNode<V>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<V> node = queue.remove();
            System.out.println(node);
            if(node.leftChild() != null) queue.add(node.leftChild());
            if(node.rightChild() != null) queue.add(node.rightChild());
        }

        return this;
    }

    //visitor, order type, etc
    Tree<V> traverse() {
        if(root == null) {
            System.out.println("Empty");
            return this;
        }

        postOrder(root);
        return this;
    }

    private void inOrder(TreeNode<V> node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    private void preOrder(TreeNode<V> node) {
        if(node == null) return;

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(TreeNode<V> node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public static class TreeNode<V> {
        V value;
        TreeNode<V> parent;
        TreeNode<V> left;
        TreeNode<V> right;

        static <V extends Comparable<V>> TreeNode<V> root(V value) {
            return new TreeNode<>(value, null, null, null);
        }

        static <V extends Comparable<V>> TreeNode<V> leaf(V newValue, TreeNode<V> parent) {
            return new TreeNode<>(newValue, parent, null, null);
        }

        TreeNode(V value, TreeNode<V> parent, TreeNode<V> left, TreeNode<V> right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public V value() {
            return value;
        }

        TreeNode<V> addLeft(TreeNode<V> left) {
            this.left = left;
            return this;
        }

        TreeNode<V> addRight(TreeNode<V> right) {
            this.right = right;
            return this;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    '}';
        }

        boolean isLeaf() {
            return left == null & right == null;
        }

        public TreeNode<V> remove(TreeNode<V> node) {
            left = left == node ? null : left;
            right = right == node ? null : right;
            parent = parent == node ? null : parent;
            return this;
        }

        TreeNode<V> replaceChildWith(TreeNode<V> node, TreeNode<V> replacer) {
            left = left == node ? replacer : left;
            right = right == node ? replacer : right;
            replacer.parent = this;
            return this;
        }

        boolean hasOnlyRightChild() {
            return this.left == null;
        }

        boolean hasOnlyLeftChild() {
            return this.right == null;
        }

        public TreeNode<V> leftChild() {
            return left;
        }

        public TreeNode<V> rightChild() {
            return right;
        }

        public boolean hasBothChilds() {
            return !hasOnlyLeftChild() & !hasOnlyRightChild();
        }
    }
}
