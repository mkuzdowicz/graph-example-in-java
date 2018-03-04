package com.kuzdowicz.algo.graphs.directed;

import java.util.*;

public class Graph {

    private final Map<String, Set<String>> graph = new HashMap<>();

    public Graph(final String graphStringRepr) {

        Arrays.asList(graphStringRepr.split(","))
                .forEach(s -> {
                    String[] vertices = s.split("-");
                    String parentVertex = vertices[0];
                    String childVertex = vertices[1];

                    if (graph.containsKey(parentVertex)) {
                        graph.get(parentVertex).add(childVertex);
                    } else {
                        Set<String> adjacencySet = new HashSet<>();
                        adjacencySet.add(childVertex);
                        graph.put(parentVertex, adjacencySet);
                    }
                });

    }

    public Map<String, Set<String>> getGraph() {
        return new HashMap<>(graph);
    }
}
