package com.denis.shuvalov.algo.graph.sedgewick.helper.paths;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.GraphPaths;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths implements GraphPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    public BreadthFirstPaths(Graph theGraph, int source) {
        this.marked = new boolean[theGraph.vertices()];
        this.edgeTo = new int[theGraph.vertices()];
        this.source = source;

        bfs(theGraph, source);
    }

    private void bfs(Graph theGraph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        marked[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (Integer w : theGraph.adjacentTo(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
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
