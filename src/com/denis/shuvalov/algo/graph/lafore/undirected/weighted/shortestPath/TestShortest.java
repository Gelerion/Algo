package com.denis.shuvalov.algo.graph.lafore.undirected.weighted.shortestPath;

public class TestShortest {
	public static void main(String[] args) {
		ShortestPathSelectionGrpah grpah = new ShortestPathSelectionGrpah();

		grpah.addVertex('A'); // 0
		grpah.addVertex('B'); // 1
		grpah.addVertex('C'); // 2
		grpah.addVertex('D'); // 3
		grpah.addVertex('E'); // 4

		grpah.addEdge(0, 1, 50); // AB 50
		grpah.addEdge(0, 3, 80); // AD 80
		grpah.addEdge(1, 3, 90); // BD 90
		grpah.addEdge(1, 2, 60); // BC 60
		grpah.addEdge(2, 4, 40); // CE 40
		grpah.addEdge(3, 2, 20); // DC 20
		grpah.addEdge(3, 4, 70); // DE 70
		grpah.addEdge(4, 1, 50); // EB 50

		grpah.shortestPath();
	}
}
