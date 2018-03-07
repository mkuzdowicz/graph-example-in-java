package com.kuzdowicz.algo.graphs;

import com.kuzdowicz.algo.graphs.directed.weighted.DirectedWightedGraph;

public class WeightedGraphApp {

    public static void main(String[] args) {

        DirectedWightedGraph g = new DirectedWightedGraph("a-1-b,b-1-c,a-1-c");
        println(g);

        g.findShortestPath("a", "c");
    }

    private static void println(Object o) {
        System.out.println(o);
    }

}
