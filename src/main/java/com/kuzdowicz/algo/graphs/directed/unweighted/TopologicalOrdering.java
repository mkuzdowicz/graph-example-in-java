package com.kuzdowicz.algo.graphs.directed.unweighted;

import java.util.*;

class TopologicalOrdering {

    static List<String> getVerticesInTopologicalOrderFrom(DirectedUnweightedGraph g) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        List<String> pathInTopologicalOrder = new ArrayList<>();

        g.getAllVertices().forEach(v -> {
            if (!visited.contains(v)) {
                dfs(g, v, visited, stack);
            }
        });

        while (!stack.isEmpty()) {
            pathInTopologicalOrder.add(stack.pop());
        }

        return pathInTopologicalOrder;
    }

    private static void dfs(DirectedUnweightedGraph graph, String currentVertex, Set<String> visited, Stack<String> stack) {
        visited.add(currentVertex);

        for (String adjacent : graph.getAdjacencySetsMap().get(currentVertex)) {
            if (!visited.contains(adjacent)) dfs(graph, adjacent, visited, stack);
        }

        stack.push(currentVertex);

    }

}
