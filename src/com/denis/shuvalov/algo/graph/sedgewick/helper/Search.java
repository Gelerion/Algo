package com.denis.shuvalov.algo.graph.sedgewick.helper;

public interface Search {
	// s - source vertex

	// is v is connected with s
	boolean marked(int v);

	// amount of vertices connected with s
	int count();
}
