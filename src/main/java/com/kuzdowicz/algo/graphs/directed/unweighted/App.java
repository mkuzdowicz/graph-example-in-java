package com.kuzdowicz.algo.graphs.directed.unweighted;

import com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted.DirectedUnweightedGraph;

public class App {

    public static void main(String[] args) {

        String graphStrRepr = "a-b,a-c,c-e,b-d,e-b,e-d";
        DirectedUnweightedGraph graph = new DirectedUnweightedGraph(graphStrRepr);

        println("Creating graph from string => " + graphStrRepr + " : \n");
        println(graph.getAdjacencySetsMap());

        println("shortest path from a to d is: \n");
        println(graph.findShortestPath("a", "d"));

        println("shortest path from c to a is: \n");
        println(graph.findShortestPath("c", "a"));
    }

    private static void println(Object o) {
        System.out.println(o);
    }
}
