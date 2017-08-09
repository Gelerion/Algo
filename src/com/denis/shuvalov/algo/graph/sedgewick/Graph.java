package com.denis.shuvalov.algo.graph.sedgewick;

public interface Graph {

    //amount of vertices in graph
    int vertices();

    //amount of edges in graph
    int edges();

    Graph addEdge(int from, int to);

    //get vertices adjacent to provided vertex
    Iterable<Integer> adjacentTo(int vertex);

    //number of edges incident to the vertex
    default int degree(int vertex) {
        int degree = 0;
        for (Integer w : adjacentTo(vertex)) degree++;
        return degree;
    }

    default int maxDegree() {
        int max = 0;
        for (int v = 0; v < vertices(); v++) {
            if (degree(v) > max) max = degree(v);
        }
        return max;
    }

    //avgDegree
    //numOfSelfLoops
}
