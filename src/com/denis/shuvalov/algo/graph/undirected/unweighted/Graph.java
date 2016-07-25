package com.denis.shuvalov.algo.graph.undirected.unweighted;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; // Массив вершин
    private int[][] adjMatrix; // Матрица смежности
    private int nVerts; // Текущее количество вершин

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.adjMatrix = new int[MAX_VERTS][MAX_VERTS];
    }

    void addVertx(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    void addEdge(int start, int end) {
        adjMatrix[start][end] = 1; //triangle
        adjMatrix[end][start] = 1;
    }

    void displayVertx(int v) {
        System.out.println(vertexList[v].label);
    }

    //Minimum Spanning Tree
    //минимальное состовное дерево
    void mst() {
        Stack stack = new Stack();
        vertexList[0].wasVisited = true;
        stack.push(0);

        int previous = 0;
        while (!stack.isEmpty()) {
            int current = getAdjUnvisitedVertex(stack.peek());
            if (current == -1) stack.pop();
            else {
                vertexList[current].wasVisited = true;
                System.out.print(vertexList[previous].label);
                System.out.print(vertexList[current].label + " ");

                previous = current;
                stack.push(current);
            }
        }

        for (int j = 0; j < nVerts; j++)
            // Сброс флагов
            vertexList[j].wasVisited = false;

    }

    void mstOnBfs() {
        Queue<Integer> list = new ArrayDeque<>();
        list.add(0);
        vertexList[0].wasVisited = true;

        while (!list.isEmpty()) {
            Integer current = list.remove();

            int next;
            while ((next = getAdjUnvisitedVertex(current)) != -1) {
                list.add(next);
                vertexList[next].wasVisited = true;

                System.out.print(vertexList[current]);
                System.out.print(vertexList[next] + " ");
            }
        }
    }

    void bookDfs() {
        Stack stack = new Stack();
        vertexList[0].wasVisited = true;
        System.out.print(vertexList[0].label);
        stack.push(0);

        while (!stack.isEmpty()) {
            // Получение непосещенной вершины, смежной к текущей
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) stack.pop(); // Если такой вершины нет, элемент извлекается из стека
            else {
                vertexList[v].wasVisited = true; // Пометка
                System.out.print(vertexList[v].label + " "); // Вывод
                stack.push(v); // Занесение в стек
            }
        }

        // Стек пуст, работа закончена
        for (int j = 0; j < nVerts; j++)
            // Сброс флагов
            vertexList[j].wasVisited = false;
    }

    //Depth-First Search
    void dfs() {
        PairStack pairStack = new PairStack();
        System.out.print("Visits: ");
        depthSearch(0, pairStack);

        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;

    }

    //Breadth-First Search
    void bfs() {
        Queue<Integer> list = new LinkedList<>();
        System.out.print("Visits: ");

        int currentVertex = 0;
        System.out.print(vertexList[currentVertex] + " -> ");
        vertexList[currentVertex].wasVisited = true;
        list.add(currentVertex);

        while (!list.isEmpty()) {
            currentVertex = list.remove();

            int possibleNext;
            while ((possibleNext = getAdjUnvisitedVertex(currentVertex)) != -1) {
                list.add(possibleNext);
                System.out.print(vertexList[possibleNext] + " -> ");
                vertexList[possibleNext].wasVisited = true;
            }
        }

        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;
    }

    void depthSearch(int currIndex, PairStack stack) {
        if (currIndex == -1) return;

        Vertex visited = vertexList[currIndex];
        System.out.print(visited + " -> ");
        visited.wasVisited = true;
        stack.push(visited, currIndex);

        depthSearch(getAdjUnvisitedVertex(currIndex), stack);

        Pair<Vertex, Integer> top = stack.pop();
        //has more edges
        int possibleNext = getAdjUnvisitedVertex(top.getValue());
        while (possibleNext != -1) {
            depthSearch(possibleNext, stack);
            possibleNext = getAdjUnvisitedVertex(top.getValue());
        }
    }

    // Метод возвращает непосещенную вершину, смежную по отношению к v
    int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < adjMatrix[v].length; i++) {
            if (adjMatrix[v][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }

        return -1;
    }

    private static class PairStack {
        int size;
        private Pair<Vertex, Integer>[] array;

        @SuppressWarnings("all")
        PairStack() {
            array = (Pair<Vertex, Integer>[]) Array.newInstance(Pair[].class.getComponentType(), 5);
        }

        void push(Vertex vertex, int index) {
            if (size > array.length) array = Arrays.copyOf(array, (int) (array.length * 1.7));
            array[size++] = new Pair<>(vertex, index);
        }

        Pair<Vertex, Integer> pop() {
            Pair<Vertex, Integer> result = array[--size];
            array[size] = null;
            return result;
        }
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
}
