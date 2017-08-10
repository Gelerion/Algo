package com.denis.shuvalov.algo.graph.sedgewick.helper;

public interface GraphPaths {

    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);
}
