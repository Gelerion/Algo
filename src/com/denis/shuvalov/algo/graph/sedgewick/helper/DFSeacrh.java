package com.denis.shuvalov.algo.graph.sedgewick.helper;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;

//Depth First Search
public class DFSeacrh implements Search {
	private final Graph theGraph;
	private final int s;

	// s - source
	public DFSeacrh(Graph theGraph, int s) {
		this.theGraph = theGraph;
		this.s = s;
	}

	@Override
	public boolean marked(int v) {
		// theGraph.adjacentTo(v)
		return false;
	}

	@Override
	public int count() {
		return 0;
	}
}
