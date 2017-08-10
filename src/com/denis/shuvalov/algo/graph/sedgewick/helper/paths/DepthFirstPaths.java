package com.denis.shuvalov.algo.graph.sedgewick.helper.paths;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.GraphPaths;

import java.util.Collections;
import java.util.Stack;

public class DepthFirstPaths implements GraphPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph theGraph, int source) {
        this.marked = new boolean[theGraph.vertices()];
        this.edgeTo = new int[theGraph.vertices()];
        this.source = source;

        dfs(theGraph, source);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;

        for (Integer w : graph.adjacentTo(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        Collections.reverse(path); //to preserve LIFO in iterator
        return path;
    }
}
