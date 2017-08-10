package com.denis.shuvalov.algo.graph.sedgewick.helper.search;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.Search;

//Depth First Search
public class DepthFirstSearch implements Search {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph theGraph, int source) {
		marked = new boolean[theGraph.vertices()];
		dfs(theGraph, source);
	}

	private void dfs(Graph theGraph, int v) {
		marked[v] = true;
		count++;

		for (Integer w : theGraph.adjacentTo(v)) {
			if(!marked(w)) dfs(theGraph, w);
		}
	}

	@Override
	public boolean marked(int v) {
		return marked[v];
	}

	@Override
	public int count() {
		return count;
	}
}
