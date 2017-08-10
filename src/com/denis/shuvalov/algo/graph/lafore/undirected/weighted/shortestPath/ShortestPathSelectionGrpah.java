package com.denis.shuvalov.algo.graph.lafore.undirected.weighted.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Алгоритм Дейкстры
 * <p>
 * Задача выбора кратчайшего пути
 */
public class ShortestPathSelectionGrpah {
	private List<Vr> verticies = new ArrayList<>();
	private int[][] adjMatrix = new int[5][5];

	void addVertex(char label) {
		verticies.add(new Vr(label));
	}

	void addEdge(int from, int to, int value) {
		adjMatrix[from][to] = value;
	}

	void shortestPath() {
		int[][] copyAdjMatrix = copy(adjMatrix);
		int[][] paths = new int[copyAdjMatrix.length - 1][copyAdjMatrix.length - 1];

		int vertex = 0;
		int[] pathsWeights = getPathsFor(vertex, copyAdjMatrix);
		System.out.println("Step A: " + Arrays.toString(pathsWeights));
	}

	private int[] getPathsFor(int vertex, int[][] matrix) {
		int[] result = new int[matrix.length - 1];

		boolean skiped = false;
		for (int i = 0; i < matrix[vertex].length; i++) {
			if (i == vertex) {
				skiped = true;
				continue;
			}
			int weight = matrix[vertex][i] == 0 ? Integer.MAX_VALUE : matrix[vertex][i];

			if (skiped) {
				result[i - 1] = weight;
			} else {
				result[i] = weight;
			}
		}

		return result;
	}

	private int[][] copy(int[][] input) {
		int[][] target = new int[input.length][];
		for (int i = 0; i < input.length; i++) {
			target[i] = Arrays.copyOf(input[i], input[i].length);
		}
		return target;
	}

	private class Vr {
		private char label;
		private boolean wasVisited;

		Vr(char label) {
			this.label = label;
		}
	}
}
