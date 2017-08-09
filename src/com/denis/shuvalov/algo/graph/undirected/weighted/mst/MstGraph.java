package com.denis.shuvalov.algo.graph.undirected.weighted.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Минимальное остовное дерево во взвешенных графах
 * <p>
 * Предположим, мы хотим проложить линию кабельного телевидения, соединяю- щую
 * шесть городов некоей вымышленной страны. Для соединения шести городов
 * потребуется пять сегментов, но каких именно?
 */
public class MstGraph {
	private int[][] adjacencyMatrix = new int[20][20]; // limited
	private ArrayList<Vertex> vertices = new ArrayList<>();

	void addVertex(char label) {
		vertices.add(new Vertex(label));
	}

	void addEdge(int from, int to, int weight) {
		adjacencyMatrix[from][to] = weight;
		adjacencyMatrix[to][from] = weight;
	}

	void mst() {
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		ArrayList<Edge> road = new ArrayList<>();

		// в качестве отправной точки лучше всего выбрать самый дешевый сегмент
		int source = 0;

		while (true) {
			vertices.get(source).wasVisited = true;
			List<Integer> vertexEdges = getEdges(source);
			if (!vertexEdges.isEmpty()) {
				for (Integer dest : vertexEdges) {
					edges.add(new Edge(source, dest, adjacencyMatrix[source][dest]));
				}
			} else
				break;

			System.out.println("-------------------------------------------");
			print(edges);
			System.out.println("-------------------------------------------");

			Edge lowestWeightEdge = edges.poll();
			source = lowestWeightEdge.destVert;
			road.add(lowestWeightEdge);

			System.out.println("Road: " + road);
		}

	}

	private void print(PriorityQueue<Edge> edges) {
		PriorityQueue<Edge> queue = new PriorityQueue<>(edges);
		System.out.print("Edges list: ");
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			if (i == size - 1)
				System.out.print(queue.poll());
			else
				System.out.print(queue.poll() + ", ");
		}
		System.out.println();
	}

	private List<Integer> getEdges(int current) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < adjacencyMatrix[current].length; i++) {
			if (adjacencyMatrix[current][i] != 0 && !vertices.get(i).isWasVisited()) {
				result.add(i);
			}
		}
		return result;
	}

	private static class Vertex {
		char value;
		boolean wasVisited;

		Vertex(char value) {
			this.value = value;
			this.wasVisited = false;
		}

		char getValue() {
			return value;
		}

		boolean isWasVisited() {
			return wasVisited;
		}

		public Vertex setWasVisited(boolean wasVisited) {
			this.wasVisited = wasVisited;
			return this;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private class Edge implements Comparable<Edge> {
		int sourceVert;
		int destVert;
		int distance;

		Edge(int sourceVert, int destVert, int distance) {
			this.sourceVert = sourceVert;
			this.destVert = destVert;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge that) {
			return Integer.compare(this.distance, that.distance);
		}

		public int getSourceVert() {
			return sourceVert;
		}

		public Edge setSourceVert(int sourceVert) {
			this.sourceVert = sourceVert;
			return this;
		}

		public int getDestVert() {
			return destVert;
		}

		public Edge setDestVert(int destVert) {
			this.destVert = destVert;
			return this;
		}

		public int getDistance() {
			return distance;
		}

		public Edge setDistance(int distance) {
			this.distance = distance;
			return this;
		}

		@Override
		public String toString() {
			return "Edge{" + vertices.get(sourceVert) + " -> " + vertices.get(destVert) + " : " + distance + "}";
		}
	}
}
