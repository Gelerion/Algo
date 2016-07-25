package com.denis.shuvalov.algo.graph.undirected.unweighted;

public class TestGrpah {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertx('A');
        graph.addVertx('B');
        graph.addVertx('C');
        graph.addVertx('D');
        graph.addVertx('E');
        graph.addVertx('F');
        graph.addVertx('G');
        graph.addVertx('H');
        graph.addVertx('I');

        graph.addEdge(0, 1); //A -> B
        graph.addEdge(0, 2); //A -> C
        graph.addEdge(0, 3); //A -> D
        graph.addEdge(0, 4); //A -> E
        graph.addEdge(1, 5); //B -> F
        graph.addEdge(5, 7); //F -> H
        graph.addEdge(3, 6); //D -> G
        graph.addEdge(6, 8); //G -> I

        System.out.println("Depth-First Search");
        graph.dfs(); //A -> B -> F -> H -> C -> D -> G -> I -> E ->
        System.out.println();
        graph.bookDfs();

        System.out.println("\nBreadth-First Search");
        graph.bfs(); //A -> B -> C -> D -> E -> F -> G -> H -> I ->


        Graph theGraph = new Graph();
        theGraph.addVertx('A');
        theGraph.addVertx('B');
        theGraph.addVertx('C');
        theGraph.addVertx('D');
        theGraph.addVertx('E');
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(0, 2); // AC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(1, 3); // BD
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 3); // CD
        theGraph.addEdge(2, 4); // CE
        theGraph.addEdge(3, 4); // DE

        System.out.println("\nMinimum Spanning Tree");
        theGraph.mst(); //AB BC CD DE
        System.out.println();
        theGraph.mstOnBfs(); //AB BC CD DE

    }
}
