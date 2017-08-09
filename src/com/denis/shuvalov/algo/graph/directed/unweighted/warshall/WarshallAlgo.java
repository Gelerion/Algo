package com.denis.shuvalov.algo.graph.directed.unweighted.warshall;

/**
 * В некоторых приложениях необходимо быстро определить, возможен ли переход от
 * одной вершины к другой. Допустим, вы хотите перелететь из Афин в Мурманск,
 * причем количество промежуточных пересадок вас не беспокоит. Возможен ли такой
 * перелет? Можно проанализировать таблицу связности, но это потребует просмотра
 * всех элементов отдельной строки за время O(N ) (где N — среднее количество
 * вершин, доступных от заданной вершины). У вас нет лишнего времени; существует
 * ли более быстрый способ? Оказывается, для графа можно построить таблицу,
 * которая мгновенно (то есть за время O(1)) сообщит вам, возможен ли переход от
 * одной вершины к другой. Такая таблица строится систематическим изменением
 * матрицы смежности графа. Граф, представленный такой видоизмененной матрицей
 * смежности, называется транзитивным замыканием исходного графа.
 */
public class WarshallAlgo {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList; // Массив вершин
	private int[][] adjMatrix; // Матрица смежности
	private int nVerts; // Текущее количество вершин

	public WarshallAlgo() {
		this.vertexList = new Vertex[MAX_VERTS];
		this.adjMatrix = new int[MAX_VERTS][MAX_VERTS];
	}

	void addVertx(char label) {
		vertexList[nVerts++] = new Vertex(label);
	}

	void addEdge(int start, int end) {
		adjMatrix[start][end] = 1; // triangle
		adjMatrix[end][start] = 1;
	}

	void createTransitiveTable() {

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
