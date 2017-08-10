package com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.GraphPaths;
import com.denis.shuvalov.algo.graph.sedgewick.helper.paths.DepthFirstPaths;
import com.denis.shuvalov.algo.graph.sedgewick.helper.search.DepthFirstSearch;
import com.denis.shuvalov.algo.graph.sedgewick.helper.Search;

public class GraphTest {
	public static void main(String[] args) throws IOException, URISyntaxException {
//        Graph graph = new SimpleGraph(13);
		URI tiny = GraphTest.class.getResource(
				"/com/denis/shuvalov/algo/graph/sedgewick/input/tinyG.txt").toURI();
		URI tinyConnected = GraphTest.class.getResource(
				"/com/denis/shuvalov/algo/graph/sedgewick/input/tinyCG.txt").toURI();
		URI medium = GraphTest.class.getResource(
				"/com/denis/shuvalov/algo/graph/sedgewick/input/mediumG.txt").toURI();

		BufferedReader in = Files.newBufferedReader(Paths.get(tinyConnected));
        Graph graph = new SimpleGraph(in);
		//System.out.println(graph);

        in.close();

		int source = 0;
		System.out.println("Source: " + source);

		//----------------- Search -----------------
		Search search = new DepthFirstSearch(graph, source);
		for (int v = 0; v < graph.vertices(); v++)
			if (search.marked(v)) System.out.print(v + " ");

		System.out.println();

		if (search.count() != graph.vertices()) System.out.print("NOT ");
		System.out.println("connected");

		System.out.println();

		//----------------- Connectivity -----------------
		GraphPaths paths = new DepthFirstPaths(graph, source);
		for (int v = 0; v < graph.vertices(); v++) {
			System.out.print(source + " to " + v + ": ");
			if(paths.hasPathTo(v)) {
				for (Integer x : paths.pathTo(v)) {
					if(x == source) System.out.print(x);
					else System.out.print("-" + x);
				}
				System.out.println();
			}
		}

	}
}
