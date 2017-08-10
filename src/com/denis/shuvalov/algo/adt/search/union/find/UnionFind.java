package com.denis.shuvalov.algo.adt.search.union.find;

//http://algs4.cs.princeton.edu/15uf/
//print only new connections
public interface UnionFind {

	// connect p with q
	void union(int p, int q); // reduce components count

	// id for component p
	int find(int p);

	// true if same components
	int count();

	default boolean connected(int p, int q) {
		return find(p) == find(q);
	}
}
