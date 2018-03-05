package com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted;

import java.util.*;

class PathFindingUtils {

    static List<String> findShortestPath(DirectedUnweightedGraph graph, String src, String dest) {

        Set<String> visited = new HashSet<>();
        Map<String, String> nodeToPredecessor = new HashMap<>();
        nodeToPredecessor.put(src, null);

        Queue<String> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            if (current.equals(dest)) return buildPathFrom(dest, nodeToPredecessor);

            visited.add(current);

            for (String adjacent : graph.getAdjacencySetsMap().get(current)) {
                if (!visited.contains(adjacent)) {
                    queue.add(adjacent);
                    visited.add(adjacent);
                    nodeToPredecessor.put(adjacent, current);
                }
            }
        }

        return new ArrayList<>();
    }

    private static List<String> buildPathFrom(String dest, Map<String, String> prevToCurrent) {
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

    ////////////////////////////////////////////////////////////////////////////

    static List<String> findShortestPathImpl2(DirectedUnweightedGraph graph, String src, String dest) {

        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(src));

        while (!queue.isEmpty()) {
            List<String> currentPath = queue.remove();
            String current = currentPath.get(currentPath.size() - 1);
            visited.add(current);

            if (current.equals(dest)) return currentPath;

            for (String adjacent : graph.getAdjacencySetsMap().get(current)) {
                if (!visited.contains(adjacent)) {
                    List<String> pathCopy = new ArrayList<>();
                    pathCopy.addAll(currentPath);
                    pathCopy.add(adjacent);
                    queue.add(pathCopy);
                    visited.add(adjacent);
                }
            }
        }

        return new ArrayList<>();
    }

}
