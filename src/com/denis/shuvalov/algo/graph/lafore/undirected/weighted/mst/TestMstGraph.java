package com.denis.shuvalov.algo.graph.lafore.undirected.weighted.mst;

public class TestMstGraph {
	public static void main(String[] args) {
		MstGraph mstGraph = new MstGraph();

		mstGraph.addVertex('A'); // 0
		mstGraph.addVertex('B'); // 1
		mstGraph.addVertex('C'); // 2
		mstGraph.addVertex('D'); // 3
		mstGraph.addVertex('E'); // 4
		mstGraph.addVertex('F'); // 5

		mstGraph.addEdge(0, 1, 6); // AB 6
		mstGraph.addEdge(0, 3, 4); // AD 4
		mstGraph.addEdge(1, 4, 7); // BE 7
		mstGraph.addEdge(1, 3, 7); // BD 7
		mstGraph.addEdge(1, 2, 10); // BC 10
		mstGraph.addEdge(2, 3, 8); // CD 8
		mstGraph.addEdge(2, 4, 5); // CE 5
		mstGraph.addEdge(2, 5, 6); // CF 6
		mstGraph.addEdge(3, 4, 12); // DE 12
		mstGraph.addEdge(4, 5, 8); // EF 8

		mstGraph.mst();

	}
}
