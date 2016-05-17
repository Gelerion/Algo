package com.denis.shuvalov.algo.adt.tree;

public interface AdtTree<E> extends Iterable<E> {

    /**
     * Returns the element stored at this position.
     */
    E getElemnt();

    /**
     * Returns the position of the root of the tree
     * (or null if empty).
     */
    E root();

}
