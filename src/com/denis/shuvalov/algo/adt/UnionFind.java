package com.denis.shuvalov.algo.adt;

//print only new connections
public class UnionFind {
	int nodes;

	// nodes count
	public UnionFind(int nodes) {
		this.nodes = nodes;
	}

	// connect p with q
	void union(int p, int q) { // reduce components count

	}

	// id for component p
	int find(int p) {
		return -1;
	}

	// true if same components
	boolean connected(int p, int q) {
		return false;
	}

	int count() {
		return nodes;
	}
}
