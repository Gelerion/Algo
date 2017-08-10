package com.denis.shuvalov.algo.graph.lafore.directed.unweighted;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DirectedGraph {
    private final int MAX_VERTICES = 20;
    private int[][] adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    private Vertex verticesList[] = new Vertex[MAX_VERTICES];
    private int size;

    void addVertex(char label) {
        Vertex newest = new Vertex(label);
        verticesList[size++] = newest;
    }

    void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1; //from -> to directed
    }

    //Topological sort
    void topo() {
//        Vertex[] verticesCopy = Arrays.copyOf(verticesList, size);
//
//        int[][] matrixCopy = new int[MAX_VERTICES][MAX_VERTICES];
//        for (int i = 0; i < adjacencyMatrix.length; i++) {
//                System.arraycopy(adjacencyMatrix[i], 0, matrixCopy[i], 0, adjacencyMatrix.length);
//        }

        Deque<Vertex> queue = new LinkedList<>();
        int index = findVertexWithoutSuccessor(adjacencyMatrix);
        while (index != -1) {
            System.out.println(verticesList[index]);
            queue.addFirst(verticesList[index]);
            deleteVertex(index);
            index = findVertexWithoutSuccessor(adjacencyMatrix);
        }

        System.out.println(queue);
    }

    void deleteVertex(int index) {
        size--;
//        System.out.println("Before: " + Arrays.toString(verticesList));
        if (index < size) {
//            System.out.println("Delete: " + verticesList[index] + " : " + index);
            Vertex[] copy = new Vertex[MAX_VERTICES];
            System.arraycopy(verticesList, 0, copy, 0, index);
            System.arraycopy(verticesList, index + 1, copy, index, verticesList.length - index - 1);

            verticesList = copy;
        }
        else if (index <= size) verticesList = Arrays.copyOfRange(verticesList, 0, size);
        else System.out.println("Not in list");

//        System.out.println("After: " + Arrays.toString(verticesList));
        deleteInMatrix(index);
    }

    private void deleteInMatrix(int index) {
//        System.out.println("Delete index: " + index + " Size: " + size);
//        print("Before", adjacencyMatrix);
        //move up row
        for (int i = index + 1; i < size + 1; i++) {
            int[] nextRow = adjacencyMatrix[i];
            adjacencyMatrix[i - 1] = nextRow; //row to delete
            //last one
            if (i == size) adjacencyMatrix[i] = new int[MAX_VERTICES];

        }

        //copy column
        for (int i = 0; i < size + 1; i++) {
            int[] row = adjacencyMatrix[i];
            int[] copy = new int[MAX_VERTICES];
            System.arraycopy(row, 0, copy, 0, index);
            System.arraycopy(row, index + 1, copy, index, size - index);
            adjacencyMatrix[i] = copy;
        }

//        print("After", adjacencyMatrix);

    }

    private void print(String s, int[][] adjacencyMatrix) {
        System.out.println(s);
        for (int i = 0; i < size + 1; i++) {
            System.out.print(i + " [");
            for (int j = 0; j < size + 1; j++) {
                System.out.print(adjacencyMatrix[i][j] + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }


    private int findVertexWithoutSuccessor(int[][] matrix) {
        boolean found;
        for (int i = 0; i < size; i++) {
            found = false;
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }

        return -1;
    }

    static class Vertex {
        public boolean wasVisited;
        private char label;

        public Vertex(char label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

}
