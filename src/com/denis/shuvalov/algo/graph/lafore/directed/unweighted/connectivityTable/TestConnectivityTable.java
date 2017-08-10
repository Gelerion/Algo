package com.denis.shuvalov.algo.graph.lafore.directed.unweighted.connectivityTable;

public class TestConnectivityTable {
	public static void main(String[] args) {
		ConnectivityTableGraph graph = new ConnectivityTableGraph();

		graph.addVertx('A'); // 0
		graph.addVertx('B'); // 1
		graph.addVertx('C'); // 2
		graph.addVertx('D'); // 3
		graph.addVertx('E'); // 4

		graph.addEdge(0, 2); // AC
		graph.addEdge(1, 0); // BA
		graph.addEdge(1, 4); // BE
		graph.addEdge(3, 4); // DE
		graph.addEdge(4, 2); // EC

		// AC
		// BACE
		// C
		// DEC
		// EC
		graph.connectTable();
	}

}
