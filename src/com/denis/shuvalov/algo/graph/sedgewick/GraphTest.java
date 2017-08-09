package com.denis.shuvalov.algo.graph.sedgewick;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted.SimpleGraph;

public class GraphTest {
	public static void main(String[] args) throws IOException, URISyntaxException {
//        Graph graph = new SimpleGraph(13);
		URI tiny = GraphTest.class.getResource("undirected/unweighted/tinyG.txt").toURI();
		URI medium = GraphTest.class.getResource("undirected/unweighted/mediumG.txt").toURI();

		BufferedReader in = Files.newBufferedReader(Paths.get(tiny));
        Graph graph = new SimpleGraph(in);
		System.out.println(graph);

        in.close();

    }
}
