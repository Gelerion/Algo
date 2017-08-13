package com.denis.shuvalov.algo.graph.goodrich.adt.test;

import com.denis.shuvalov.algo.graph.goodrich.adt.Edge;
import com.denis.shuvalov.algo.graph.goodrich.adt.Graph;
import com.denis.shuvalov.algo.graph.goodrich.adt.Graphs;
import com.denis.shuvalov.algo.graph.goodrich.adt.Vertex;
import com.denis.shuvalov.algo.graph.goodrich.adt.impl.AdjacencyMapGraph;

public class AdtGraphTest {

    public static void main(String[] args) {
        Graph<String, String> graph = new AdjacencyMapGraph<>(false);
        fill(graph);
        //System.out.println(graph);

        System.out.println("Is connected: " + Graphs.isConnected(graph));

        Iterable<Vertex<String>> dfs = Graphs.dfs(graph, graph.findVertex("A"));
        System.out.println(" --- DFS ---");
        int total = 0;
        for (Vertex<String> vertex : dfs) {
            total++;
            System.out.print(vertex.getElement() + " -> ");
        }
        System.out.println("Total: " + total);

        Iterable<Vertex<String>> bfs = Graphs.bfs(graph, graph.findVertex("A"));
        System.out.println(" --- BFS ---");
        total = 0;
        for (Vertex<String> vertex : bfs) {
            total++;
            System.out.print(vertex.getElement() + " -> ");
        }
        System.out.println("Total: " + total);

        System.out.println("From A to I");
        Iterable<Vertex<String>> path = Graphs.constructPath(graph, graph.findVertex("A"), graph.findVertex("I"));
        for (Vertex<String> vertex : path) {
            System.out.print(vertex + " -> ");
        }
    }

    private static void fill(Graph<String, String> graph) {
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        Vertex<String> f = graph.insertVertex("F");
        Vertex<String> g = graph.insertVertex("G");
        Vertex<String> h = graph.insertVertex("H");
        Vertex<String> i = graph.insertVertex("I");
        Vertex<String> j = graph.insertVertex("J");
        Vertex<String> k = graph.insertVertex("K");
        Vertex<String> l = graph.insertVertex("L");
        Vertex<String> m = graph.insertVertex("M");
        Vertex<String> n = graph.insertVertex("N");
        Vertex<String> o = graph.insertVertex("O");
        Vertex<String> p = graph.insertVertex("P");

        graph.insertEdge(a, f, "");
        graph.insertEdge(a, e, "");
        graph.insertEdge(a, b, "");

        graph.insertEdge(b, c, "");
        graph.insertEdge(b, f, "");

        graph.insertEdge(c, g, "");
        graph.insertEdge(c, d, "");

        graph.insertEdge(d, g, "");
        graph.insertEdge(d, h, "");

        graph.insertEdge(e, f, "");
        graph.insertEdge(e, i, "");

        graph.insertEdge(f, i, "");

        graph.insertEdge(g, j, "");
        graph.insertEdge(g, k, "");
        graph.insertEdge(g, l, "");

        graph.insertEdge(h, l, "");

        graph.insertEdge(i, j, "");
        graph.insertEdge(i, m, "");
        graph.insertEdge(i, n, "");

        graph.insertEdge(j, k, "");

        graph.insertEdge(k, n, "");
        graph.insertEdge(k, o, "");

        graph.insertEdge(l, p, "");

        graph.insertEdge(m, n, "");
    }
}
