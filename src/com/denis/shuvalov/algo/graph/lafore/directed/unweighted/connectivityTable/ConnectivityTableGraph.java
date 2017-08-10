package com.denis.shuvalov.algo.graph.lafore.directed.unweighted.connectivityTable;

import java.util.Stack;

/**
 * Программу dfs легко изме- нить таким образом, чтобы обход последовательно
 * начинался с каждой вершины. Вот как выглядит результат ее выполнения для
 * графа: AC BACE C DEC EC Мы получили таблицу связности для направ- ленного
 * графа. Первая буква в строке определяет граф начальную вершину, а остальные
 * буквы — вершины, к которым можно перейти (напрямую или через другие вершины)
 * от начальной вершины.
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

	void connectTable() {
		for (int i = 0; i < nVerts; i++) {
			System.out.print(vertexList[i] + " ");
			vertexList[i].wasVisited = true;

			Stack<Integer> stack = new Stack<>();
			stack.add(i);

			while (!stack.isEmpty()) {
				Integer curr = stack.peek();
				int next = getNext(curr);

				if (next == -1) {
					stack.pop();
				} else {
					stack.add(next);
					System.out.print(vertexList[next] + " ");
					vertexList[next].wasVisited = true;
				}
			}

			System.out.println();
			for (int j = 0; j < nVerts; j++) {
				vertexList[j].wasVisited = false;
			}
		}
	}

	private int getNext(int index) {
		for (int i = 0; i < adjMatrix[index].length; i++) {
			if (adjMatrix[index][i] == 1 && !vertexList[i].wasVisited) {
				return i;
			}
		}

		return -1;
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
