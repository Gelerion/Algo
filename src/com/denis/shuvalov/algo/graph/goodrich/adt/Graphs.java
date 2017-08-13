package com.denis.shuvalov.algo.graph.goodrich.adt;

import java.util.*;

public class Graphs {

    public static <V, E> Iterable<Vertex<V>> dfs(Graph<V, E> graph, Vertex<V> v) {
        List<Vertex<V>> visited = new ArrayList<>();
        return dfs(graph, v, visited, null);
    }

    public static <V, E> Map<Vertex<V>,Edge<E>> completeDfs(Graph<V, E> graph, Vertex<V> v) {
        Set<Vertex<V>> known = new HashSet<>();
        HashMap<Vertex<V>, Edge<E>> forest = new HashMap<>();

        for (Vertex<V> w : graph.vertices()) {
            if(!known.contains(w)) dfs(graph, w, known, forest); //(re)start the dfs process
        }

        return forest;
    }

    public static <V, E> Iterable<Vertex<V>> bfs(Graph<V, E> graph, Vertex<V> v) {
        List<Vertex<V>> visited = new ArrayList<>();
        return bfs(graph, v, visited, null);
    }

    /**
     * We can use the basic DFS method to determine whether a graph is connected. In
     * the case of an undirected graph, we simply start a depth-first search at an arbitrary
     * vertex and then test whether visited.size( ) equals n at the conclusion. If the graph
     * is connected then all vertices will have been discovered
     */
    public static <V, E> boolean isConnected(Graph<V, E> graph) {
        List<Vertex<V>> visited = new ArrayList<>();
        for (Vertex<V> v : graph.vertices()) {
            dfs(graph, v, visited, null);
            break;
        }
        return visited.size() == graph.numVertices();
    }

    /**
     * For directed graph, G, we may wish to test whether it is strongly connected, that
     * is, whether for every pair of vertices u and v, both u reaches v and v reaches u.
     */
    public static <V, E> boolean isStronglyConnected(Graph<V, E> graph) {
        return false;
    }

    public static <V, E> Iterable<Vertex<V>> constructPath(Graph<V, E> graph, Vertex<V> from, Vertex<V> to) {
        Deque<Edge<E>> path = new LinkedList<>();
        Deque<Vertex<V>> result = new LinkedList<>();

        HashMap<Vertex<V>, Edge<E>> forest = new HashMap<>();
        dfs(graph, from, new ArrayList<>(), forest); //fill the forest

        if (forest.get(to) != null) {//to was discovered during the search
            Vertex<V> walk = to; // we construct the path from back to front

            while (!Objects.equals(walk, from)) {
                Edge<E> edge = forest.get(walk);
                path.addFirst(edge); // add edge to *front* of path
                result.addFirst(walk); // add edge to *front* of path
                walk = graph.opposite(walk, edge); // repeat with opposite endpoint
            }
        }

        result.addFirst(from);
        return result;
    }

    //forest is a map from nonroot vertex to its discovery edge in DFS forest
    private static <V, E> Iterable<Vertex<V>> dfs(Graph<V, E> graph,
                                                  Vertex<V> current,
                                                  Collection<Vertex<V>> visited,
                                                  Map<Vertex<V>, Edge<E>> forest) {
        visited.add(current);

        for (Edge<E> outgoing : graph.outgoingEdges(current)) {
            Vertex<V> w = graph.opposite(current, outgoing);
            if (!visited.contains(w)) {
                if (forest != null) forest.put(w, outgoing); // outgoing is the tree edge that discovered w
                dfs(graph, w, visited, forest);
            }
        }

        return visited;
    }

    private static <V, E> Iterable<Vertex<V>> bfs(Graph<V, E> graph,
                                                  Vertex<V> current,
                                                  Collection<Vertex<V>> visited,
                                                  Map<Vertex<V>, Edge<E>> forest) {
        Deque<Vertex<V>> queue = new LinkedList<>();
        visited.add(current);
        queue.addLast(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();

            for (Edge<E> outgoing : graph.outgoingEdges(v)) {
                Vertex<V> next = graph.opposite(v, outgoing);
                if (!visited.contains(next)) {
                    if(forest != null) forest.put(next, outgoing);
                    queue.addLast(next);
                    visited.add(next);
                }
            }
        }

        return visited;
    }
}
