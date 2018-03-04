package com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted;

import java.util.*;

public class DirectedUnweightedGraph {

    private final Map<String, Set<String>> adjacencySetsMap = new HashMap<>();
    private final Set<String> allVertices = new HashSet<>();

    public Set<String> getAllVertices() {
        return new HashSet<>(allVertices);
    }

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
        return ShortestAndLongestReachUtils.shortestReachesFrom(this, src);
    }

}
