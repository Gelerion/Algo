package com.denis.shuvalov.algo.graph.sedgewick.helper.connected.components;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.ConnectedComponents;

public class DfsConnectedComponents implements ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public DfsConnectedComponents(Graph graph) {
    }

    @Override
    public boolean connected(int v, int w) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int id(int v) {
        return 0;
    }
}
