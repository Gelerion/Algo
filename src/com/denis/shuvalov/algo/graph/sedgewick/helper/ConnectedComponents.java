package com.denis.shuvalov.algo.graph.sedgewick.helper;

public interface ConnectedComponents {

    boolean connected(int v, int w);

    int count();

    //component identifier for v
    //between 0 and count - 1
    int id(int v);
}
