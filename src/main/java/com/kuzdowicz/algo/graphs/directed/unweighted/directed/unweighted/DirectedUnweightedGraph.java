package com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted;

import java.util.*;

public class DirectedUnweightedGraph {

    private final Map<String, Set<String>> adjacencySetsMap = new HashMap<>();
    private final Set<String> allVertices = new HashSet<>();

    public DirectedUnweightedGraph(final String graphStringRepr) {

        Arrays.asList(graphStringRepr.split(","))
                .forEach(s -> {
                    String[] currentVertices = s.split("-");
                    String parentVertex = currentVertices[0];
                    String childVertex = currentVertices[1];
                    allVertices.add(parentVertex);
                    allVertices.add(childVertex);
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

    public Map<String, Set<String>> getAdjacencySetsMap() {
        return new HashMap<>(adjacencySetsMap);
    }

    public List<String> findShortestPath(String src, String dest) {
        return PathFindingUtils.findShortestPath(this, src, dest);
    }

    public List<String> findShortestPathImpl2(String src, String dest) {
        return PathFindingUtils.findShortestPathImpl2(this, src, dest);
    }

    public List<String> shortestReachesFrom(String src) {

        Map<String, Integer> distanceTable = buildDistanceTableToAllVerticesFrom(src);
        System.out.println(distanceTable);
        List<String> shortestReaches = new ArrayList<>();

        int minDistance = 1;

        for (String key : distanceTable.keySet()) {
            int currentDist = distanceTable.get(key);
            if (!key.equals(src) && currentDist != -1) {
                if (currentDist < minDistance)
                    minDistance = currentDist;
            }
        }

        if (minDistance <= 0) return new ArrayList<>();

        for (String key : distanceTable.keySet()) {
            int currentDist = distanceTable.get(key);
            if (currentDist == minDistance)
                shortestReaches.add(key);
        }

        return shortestReaches;
    }

    private Map<String, Integer> buildDistanceTableToAllVerticesFrom(String src) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distanceTable = new HashMap<>();

        allVertices.forEach(v -> distanceTable.put(v, -1));

        queue.add(src);
        distanceTable.put(src, 0);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            for (String adjacent : adjacencySetsMap.get(current)) {
                int oldDistance = distanceTable.get(current);
                if (distanceTable.get(adjacent) == -1) {
                    queue.add(adjacent);
                    int newDistance = oldDistance + 1;
                    distanceTable.put(adjacent, newDistance);
                }
            }

        }

        return distanceTable;
    }
}
