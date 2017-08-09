package com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SimpleGraph implements Graph {
    private final int vertices;
    private int edges;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public SimpleGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        this.adj = new List[vertices];

        for (int v = 0; v < vertices; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleGraph(BufferedReader in) {
        try {
            this.vertices = Integer.parseInt(in.readLine());
            this.edges = Integer.parseInt(in.readLine());
            this.adj = new List[vertices];

            String line;
            while ((line = in.readLine()) != null) {
                String[] edges = line.split("\\s");
                int from = Integer.parseInt(edges[0]);
                int to = Integer.parseInt(edges[1]);
                if (this.adj[from] == null) {
                    this.adj[from] = new ArrayList<>();
                }

                this.adj[from].add(to);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public Graph addEdge(int from, int to) {
        adj[from].add(to);
        adj[to].add(from);
        return this;
    }

    @Override
    public Iterable<Integer> adjacentTo(int vertex) {
        return adj[vertex];
    }
}
