package com.kuzdowicz.algo.graphs;

import com.kuzdowicz.algo.graphs.directedgraph.Graph;

public class App {

    public static void main(String[] args) {

        String graphStrRepr = "a-b,a-c,c-e,b-d,e-b,e-d";
        Graph graph = new Graph(graphStrRepr);

        println("Creating graph from string => " + graphStrRepr + " : \n");
        println(graph.getGraph());

    }

    private static void println(Object o) {
        System.out.println(o);
    }
}
