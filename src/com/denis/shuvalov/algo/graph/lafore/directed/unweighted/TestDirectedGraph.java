package com.denis.shuvalov.algo.graph.lafore.directed.unweighted;

public class TestDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7

        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // AE
        graph.addEdge(1, 4); // BE
        graph.addEdge(2, 5); // CF
        graph.addEdge(3, 6); // DG
        graph.addEdge(4, 6); // EG
        graph.addEdge(5, 7); // FH
        graph.addEdge(6, 7); // GH

//        graph.deleteVertex(3);
//        graph.deleteVertex(6);
//        graph.deleteVertex(2);

        graph.topo(); //B A E D G C F H
    }
}
