package com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;

public class SimpleGraph implements Graph {
    private final int vertices;
    private int edges;
	private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public SimpleGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
		this.adj = new LinkedList[vertices];

        for (int v = 0; v < vertices; v++) {
			this.adj[v] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleGraph(BufferedReader in) {
        try {
            this.vertices = Integer.parseInt(in.readLine());
            this.edges = Integer.parseInt(in.readLine());
			this.adj = new LinkedList[vertices];

            String line;
            while ((line = in.readLine()) != null) {
                String[] edges = line.split("\\s");
				int v = Integer.parseInt(edges[0]);
				int w = Integer.parseInt(edges[1]);
				if (this.adj[v] == null) {
					this.adj[v] = new LinkedList<>();
                }

				if (this.adj[w] == null) {
					this.adj[w] = new LinkedList<>();
				}

				this.adj[v].addFirst(w);
				this.adj[w].addFirst(v);
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(vertices + " vertices " + edges + " edges\n");
		for (int v = 0; v < vertices; v++) {
			result.append(v).append(": ");
			for (Integer w : adjacentTo(v)) {
				result.append(w).append(" ");
			}
			result.append("\n");
		}

		return result.toString();
	}
}

