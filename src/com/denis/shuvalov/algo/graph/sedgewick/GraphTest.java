package com.denis.shuvalov.algo.graph.sedgewick;

import com.denis.shuvalov.algo.graph.sedgewick.undirected.unweighted.SimpleGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphTest {
    public static void main(String[] args) throws IOException {
//        Graph graph = new SimpleGraph(13);
        String tiny = "D:\\Projects\\Learning\\Algo\\src\\com\\denis\\shuvalov\\algo\\graph\\sedgewick\\undirected\\unweighted\\tinyG.txt";
        String medium = "D:\\Projects\\Learning\\Algo\\src\\com\\denis\\shuvalov\\algo\\graph\\sedgewick\\undirected\\unweighted\\mediumG.txt";


        BufferedReader in = Files.newBufferedReader(Paths.get(medium));
        Graph graph = new SimpleGraph(in);
        in.close();

    }
}
