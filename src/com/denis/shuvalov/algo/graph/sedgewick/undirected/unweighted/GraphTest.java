package com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.denis.shuvalov.algo.graph.sedgewick.Graph;
import com.denis.shuvalov.algo.graph.sedgewick.helper.ConnectedComponents;
import com.denis.shuvalov.algo.graph.sedgewick.helper.GraphPaths;
import com.denis.shuvalov.algo.graph.sedgewick.helper.connected.components.DfsConnectedComponents;
import com.denis.shuvalov.algo.graph.sedgewick.helper.paths.BreadthFirstPaths;
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
        System.out.println("----------------- Search -----------------");
		Search search = new DepthFirstSearch(graph, source);
		for (int v = 0; v < graph.vertices(); v++)
			if (search.marked(v)) System.out.print(v + " ");

		System.out.println();

		if (search.count() != graph.vertices()) System.out.print("NOT ");
		System.out.println("connected");

		System.out.println();

		//----------------- Connectivity -----------------
        System.out.println("----------------- Connectivity -----------------");
        GraphPaths paths = new BreadthFirstPaths(graph, source);
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

        System.out.println();

        //----------------- Connected Components -----------------
        System.out.println("----------------- Connected Components -----------------");
        ConnectedComponents cc = new DfsConnectedComponents(graph);
        int m = cc.count();
        System.out.println(m + " components");
        ArrayList<List<Integer>> components = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            components.add(i, new ArrayList<>());
        }

        for (int v = 0; v < graph.vertices(); v++) {
            components.get(cc.id(v)).add(v);
        }

        for (int i = 0; i < m; i++) {
            for (Integer v : components.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
