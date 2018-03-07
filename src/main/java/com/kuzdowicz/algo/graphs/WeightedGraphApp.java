package com.kuzdowicz.algo.graphs;

import com.kuzdowicz.algo.graphs.directed.weighted.DirectedWightedGraph;

import java.util.List;

public class WeightedGraphApp {

    public static void main(String[] args) {

        DirectedWightedGraph g = new DirectedWightedGraph("a-1-b,b-1-c,a-10-c");
        println("the graph:\n"+g);

        List<String> shortestPath = g.findShortestPath("a", "c");

        println("the shortest path between a and c is: " + shortestPath);
    }

    private static void println(Object o) {
        System.out.println(o);
    }

}
