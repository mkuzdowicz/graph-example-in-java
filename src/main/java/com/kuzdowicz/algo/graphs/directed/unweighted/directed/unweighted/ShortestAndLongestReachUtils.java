package com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted;

import java.util.*;

class ShortestAndLongestReachUtils {

    static List<String> shortestReachesFrom(DirectedUnweightedGraph g, String src) {

        Map<String, Integer> distanceTable = buildDistanceTableToAllVerticesFrom(g, src);
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

    private static Map<String, Integer> buildDistanceTableToAllVerticesFrom(DirectedUnweightedGraph g, String src) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distanceTable = new HashMap<>();

        g.getAllVertices().forEach(v -> distanceTable.put(v, -1));

        queue.add(src);
        distanceTable.put(src, 0);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            for (String adjacent : g.getAdjacencySetsMap().get(current)) {
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
