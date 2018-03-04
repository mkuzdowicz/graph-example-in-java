package com.kuzdowicz.algo.graphs.directed.unweighted;

import java.util.*;

public class DirectedUnweightedGraph {

    private final Map<String, Set<String>> adjacencySetsMap = new HashMap<>();

    public DirectedUnweightedGraph(final String graphStringRepr) {

        Arrays.asList(graphStringRepr.split(","))
                .forEach(s -> {
                    String[] currentVertices = s.split("-");
                    String parentVertex = currentVertices[0];
                    String childVertex = currentVertices[1];
                    if (adjacencySetsMap.containsKey(parentVertex)) {
                        adjacencySetsMap.get(parentVertex).add(childVertex);
                    } else {
                        Set<String> adjacencySet = new HashSet<>();
                        adjacencySet.add(childVertex);
                        adjacencySetsMap.put(parentVertex, adjacencySet);
                    }
                    if (!adjacencySetsMap.containsKey(childVertex)) {
                        adjacencySetsMap.put(childVertex, new HashSet<>());
                    }
                });

    }

    public Map<String, Set<String>> getGraph() {
        return new HashMap<>(adjacencySetsMap);
    }

    public List<String> findShortestPath(String src, String dest) {

        Set<String> visited = new HashSet<>();
        Map<String, String> prevToCurrent = new HashMap<>();
        prevToCurrent.put(src, null);

        Queue<String> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            if (current.equals(dest)) {

                List<String> path = new ArrayList<>();
                Stack<String> stack = new Stack<>();
                stack.push(dest);

                while (!stack.isEmpty()) {
                    String lastFromPath = stack.pop();
                    String currentCameFrom = prevToCurrent.get(lastFromPath);
                    if (currentCameFrom != null) stack.push(currentCameFrom);
                    path.add(lastFromPath);
                }

                Collections.reverse(path);

                return path;
            }

            visited.add(current);

            for (String adjacent : adjacencySetsMap.get(current)) {
                if (!visited.contains(adjacent)) {
                    queue.add(adjacent);
                    visited.add(adjacent);
                    prevToCurrent.put(adjacent, current);
                }
            }
        }

        return new ArrayList<>();
    }
}
