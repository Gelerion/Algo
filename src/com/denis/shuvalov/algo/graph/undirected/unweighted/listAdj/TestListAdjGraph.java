package com.denis.shuvalov.algo.graph.undirected.unweighted.listAdj;

public class TestListAdjGraph {
    public static void main(String[] args) {
        ListAdjGraph graph = new ListAdjGraph();

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
    }
}
