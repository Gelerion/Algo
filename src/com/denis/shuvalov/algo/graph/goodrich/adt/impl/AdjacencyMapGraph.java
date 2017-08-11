package com.denis.shuvalov.algo.graph.goodrich.adt.impl;

import com.denis.shuvalov.algo.graph.goodrich.adt.Edge;
import com.denis.shuvalov.algo.graph.goodrich.adt.Graph;
import com.denis.shuvalov.algo.graph.goodrich.adt.Vertex;

import java.lang.reflect.Array;
import java.util.*;

public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

    private boolean isDirected;
    private List<Vertex<V>> vertices;
    private List<Edge<E>> edges;

    public AdjacencyMapGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    @Override
    public int outDegree(Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex vertex = validate(v);
        return vertex.getOutgoing().size();
    }

    @Override
    public int inDegree(Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex vertex = validate(v);
        return vertex.getIncoming().size();
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex vertex = validate(v);
        return vertex.getOutgoing().values();
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex vertex = validate(v);
        return vertex.getIncoming().values();
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex origin = validate(u);
        return origin.getOutgoing().get(v); // will be null if no edge from u to v;
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
        AdjMapEdge edge = validate(e);
        return edge.getEndpoints();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
        AdjMapEdge edge = validate(e);
        Vertex<V>[] endpoints = edge.getEndpoints();
        if(endpoints[0] == v) return endpoints[1];
        if(endpoints[1] == v) return endpoints[0];
        else throw new IllegalArgumentException("v is not incident to this edge");
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        AdjMapVertex newVertex = new AdjMapVertex(element, isDirected);
        this.vertices.add(newVertex);
        return newVertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        if(getEdge(u, v) != null) throw new IllegalArgumentException("Edge from u to v exists");

        AdjMapVertex origin = validate(u);
        AdjMapVertex dest = validate(v);

        AdjMapEdge edge = new AdjMapEdge(origin, dest, element);
        this.edges.add(edge);

        origin.getOutgoing().put(dest, edge);
        dest.getIncoming().put(origin, edge);
        return edge;
    }

    @Override
    public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
        AdjMapVertex vertex = validate(v);

        // remove all incident edges from the graph
        for (Edge<E> edge : vertex.getOutgoing().values()) {
            removeEdge(edge);
        }

        for (Edge<E> edge : vertex.getIncoming().values()) {
            removeEdge(edge);
        }

        this.vertices.remove(vertex); //may be much faster with position
        vertex = null;
    }

    @Override
    public void removeEdge(Edge<E> e) throws IllegalArgumentException {
        AdjMapEdge edge = validate(e);

        // remove this edge from vertices' adjacencies
        AdjMapVertex[] verts = (AdjMapVertex[]) edge.getEndpoints();
        verts[0].getOutgoing().remove(verts[1]);
        verts[1].getOutgoing().remove(verts[0]);

        // remove this edge from the list of edges
        this.edges.remove(edge);
        edge = null;
    }

    @SuppressWarnings({"unchecked"})
    private AdjMapVertex validate(Vertex<V> v) {
        if (!(v instanceof AdjacencyMapGraph.AdjMapVertex)) throw new IllegalArgumentException("Invalid vertex");
        return (AdjMapVertex) v;     // safe cast
    }

    @SuppressWarnings({"unchecked"})
    private AdjMapEdge validate(Edge<E> e) {
        if (!(e instanceof AdjacencyMapGraph.AdjMapEdge)) throw new IllegalArgumentException("Invalid edge");
        return (AdjMapEdge) e;
    }

    /** A vertex of an adjacency map graph representation. */
    private class AdjMapVertex implements Vertex<V> {
        private V element;
        //    (U)
        //  e/   \g
        // (V)-f-(W)
        // this is vertex U holds map((V) -> e, (W) -> g)
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        AdjMapVertex(V element, boolean isDirected) {
            this.element = element;

            if(isDirected) {
                outgoing = new HashMap<>();
                incoming = new HashMap<>();
            }
            else {
                outgoing = incoming = new HashMap<>();
            }
        }

        @Override
        public V getElement() {
            return element;
        }

        Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }
    }

    /** An edge between two vertices. */
    private class AdjMapEdge implements Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;

        @SuppressWarnings({"unchecked"})
        AdjMapEdge(Vertex<V> u, Vertex<V> v, E element) {
            this.element = element;
            this.endpoints = (Vertex<V>[]) Array.newInstance(Vertex.class, 2);
            this.endpoints[0] = u;
            this.endpoints[1] = v;
        }

        @Override
        public E getElement() {
            return element;
        }

        Vertex<V>[] getEndpoints() {
            return endpoints;
        }
    }
}
