package com.denis.shuvalov.algo.graph.lafore.undirected.unweighted.listAdj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Вершина Список смежных вершин
 * A B—>C—>D
 * B A—>D
 * C A
 * D A—>B
 * <p>
 * В этой таблице знаком —> обозначается связь в списке. Элементами списка
 * являются вершины. В нашем примере вершины каждого списка упорядочены в ал-
 * фавитном порядке, хотя на самом деле это не обязательно. Не путайте содержимое
 * списков смежности с путями. Список смежности показывает, какие вершины явля-
 * ются смежными по отношению к заданной (то есть находятся от нее на расстоянии
 * одного ребра); он не является описанием пути между вершинами.
 */
public class ListAdjGraph {
    private ListrVertex[] vertices;
    //TODO: custom list with nodes inside
    private List<List<Integer>> adjList;
    private int size = 0;

    public ListAdjGraph() {
        vertices = new ListrVertex[20];
        adjList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addVertx(char label) {
        vertices[size++] = new ListrVertex(label);
    }

    //        adjMatrix[start][end] = 1; //triangle
//        adjMatrix[end][start] = 1;
    void addEdge(int start, int end) {
        List<Integer> edges = adjList.get(start);
        if (edges == null) edges = new ArrayList<>();
        edges.add(end);

        edges = adjList.get(end);
        if (edges == null) edges = new ArrayList<>();
        edges.add(start);
    }

    public void dfs() {
        Stack stack = new Stack();
        stack.push(0);
        vertices[0].wasVisited = true;

        System.out.print(vertices[0] + " -> ");

        while (!stack.isEmpty()) {
            int next = getAdjUnvisitedVertex(stack.peek());
            if (next == -1) stack.pop();
            else {
                stack.push(next);
                vertices[next].wasVisited = true;
                System.out.print(vertices[next] + " -> ");
            }
        }
    }

    private int getAdjUnvisitedVertex(int index) {
        List<Integer> list = adjList.get(index);
        if (list == null) return -1;

        for (int i = 0; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (!vertices[cur].wasVisited) {
                return cur;
            }
        }

        return -1;
    }

    private static class Stack {
        int size;
        private int[] array;

        Stack() {
            array = new int[5];
        }

        void push(int vertexIndex) {
            if (size >= array.length) array = Arrays.copyOf(array, (int) (array.length * 1.7));
            array[size++] = vertexIndex;
        }

        int peek() {
            return array[size - 1];
        }

        int pop() {
            return array[--size];
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private class ListrVertex {
        public boolean wasVisited;
        char label; // Метка (например, ‘A’)

        ListrVertex(char label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }
}
