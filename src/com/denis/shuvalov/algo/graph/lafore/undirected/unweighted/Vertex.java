package com.denis.shuvalov.algo.graph.lafore.undirected.unweighted;

//Вершины
class Vertex {
    public char label; // Метка (например, ‘A’)
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
