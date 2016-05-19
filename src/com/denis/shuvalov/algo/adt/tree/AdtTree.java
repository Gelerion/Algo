package com.denis.shuvalov.algo.adt.tree;

import com.denis.shuvalov.algo.adt.positionList.Position;

public interface AdtTree<E> extends Iterable<E> {

    /**
     * Returns the position of the root of the tree
     * (or null if empty).
     */
    Position<E> root();

}
