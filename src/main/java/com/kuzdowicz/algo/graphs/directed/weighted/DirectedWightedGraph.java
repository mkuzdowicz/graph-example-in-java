package com.kuzdowicz.algo.graphs.directed.weighted;

import java.util.*;

public class DirectedWightedGraph {

    private Map<String, Vertex> vertices = new HashMap<>();

    public DirectedWightedGraph(String representation) {

        Arrays.asList(representation.split(",")).forEach(token -> {
            List<String> srcWeightDestGroup = Arrays.asList(token.split("-"));
            String src = srcWeightDestGroup.get(0);
            String target = srcWeightDestGroup.get(2);
            int weight = Integer.parseInt(srcWeightDestGroup.get(1));
            Vertex v1;
            if (vertices.containsKey(src)) {
                v1 = vertices.get(src);
            } else {
                v1 = new Vertex(src);
                vertices.put(src, v1);
            }
            Vertex v2;
            if (vertices.containsKey(target)) {
                v2 = vertices.get(target);
            } else {
                v2 = new Vertex(target);
                vertices.put(target, v2);
            }

            addEdge(v1, v2, weight);
        });


    }

    private void addEdge(Vertex src, Vertex dest, int weight) {
        src.addAdjacentEdge(dest, weight);
    }

    @Override
    public String toString() {
        return vertices.values().toString();
    }

    private Map<Vertex, Integer> generateDistanceTableFor(String src) {

        Vertex srcVertex = vertices.get(src);
        srcVertex.setDistance(0);

        PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
        pQueue.add(srcVertex);

        Map<Vertex, Integer> distanceTable = new HashMap<>();
        distanceTable.put(srcVertex, 0);

        while (!pQueue.isEmpty()) {
            Vertex current = pQueue.poll();

            for (Edge adjacent : current.getAdjacent()) {

                Vertex adjacentV = adjacent.getTargetVertex();
                int oldDist = adjacentV.getDistance();
                int newDist = current.getDistance() + adjacent.getWeight();
                if (newDist < oldDist) {
                    pQueue.remove(adjacent);
                    adjacentV.setDistance(newDist);
                    adjacentV.setPredecessor(current);
                    pQueue.add(adjacentV);
                    distanceTable.put(adjacentV, newDist);
                }
            }
        }

        return distanceTable;

    }

    public void findShortestPath(String src, String dest) {

        Map<Vertex, Integer> distances = generateDistanceTableFor(src);

        printDistances(distances);

    }

    private void printDistances(Map<Vertex, Integer> distances) {
        distances.entrySet().forEach(e -> System.out.print(e.getKey().getData() + "=>" + e.getValue() + ", "));
    }

}
