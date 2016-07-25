package com.denis.shuvalov.algo.graph.directed.unweighted.connectivityTable;

/**
 * Программу dfs  легко изме-
 * нить таким образом, чтобы обход последовательно
 * начинался с каждой вершины. Вот как выглядит
 * результат ее выполнения для графа на рис. 13.15:
 * AC
 * BACE
 * C
 * DEC
 * EC
 * Мы получили таблицу связности для направ-
 * Рис. 13.15. Направленный
 * ленного графа. Первая буква в строке определяет
 * граф
 * начальную вершину, а остальные буквы — вершины,
 * к которым можно перейти (напрямую или через другие вершины) от начальной
 * вершины.
 */
public class ConnectivityTableGraph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; // Массив вершин
    private int[][] adjMatrix; // Матрица смежности
    private int nVerts; // Текущее количество вершин

    public ConnectivityTableGraph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.adjMatrix = new int[MAX_VERTS][MAX_VERTS];
    }

    void addVertx(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    private static class Vertex {
        public boolean wasVisited;
        private char label;

        Vertex(char label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }
}
