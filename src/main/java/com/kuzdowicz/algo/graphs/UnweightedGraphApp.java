package com.kuzdowicz.algo.graphs;

import com.kuzdowicz.algo.graphs.directed.unweighted.DirectedUnweightedGraph;

public class UnweightedGraphApp {

    public static void main(String[] args) {

        String graphStrRepr1 = "a-b,a-c,c-e,b-d,e-b,e-d";
        DirectedUnweightedGraph graph1 = new DirectedUnweightedGraph(graphStrRepr1);

        println("Creating graph1 from string => " + graphStrRepr1 + " : \n");
        println(graph1.getAdjacencySetsMap());

        println("shortest path from a to d is: \n");
        println(graph1.findShortestPath("a", "d"));

        println("shortest path from c to a is: \n");
        println(graph1.findShortestPath("c", "a"));

        println("shortest reaches from a is: \n");
        println(graph1.shortestReachesFrom("a"));

        println("shortest reaches from d is: \n");
        println(graph1.shortestReachesFrom("d"));

        println("\n----------------------------------------------------");

        String graphStrRepr2 = "3-1,4-1,4-0,5-0,5-2,2-3";
        DirectedUnweightedGraph graph2 = new DirectedUnweightedGraph(graphStrRepr2);
        println("Creating graph2 from string => " + graphStrRepr2 + " : \n");
        println(graph2.getAdjacencySetsMap());

        println("vertices in topological order");
        println(graph2.getVerticesInTopologicalOrder());
    }

    private static void println(Object o) {
        System.out.println(o);
    }
}
