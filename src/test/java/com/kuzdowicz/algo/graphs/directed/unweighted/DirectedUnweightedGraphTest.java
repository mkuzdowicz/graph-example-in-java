package com.kuzdowicz.algo.graphs.directed.unweighted;

import com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted.DirectedUnweightedGraph;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DirectedUnweightedGraphTest {

    private String graphStrRepr = "a-b,a-c,c-e,b-d,e-b,e-d";
    private DirectedUnweightedGraph graph = new DirectedUnweightedGraph(graphStrRepr);

    @Test
    public void find_shortest_path_from_a_to_d() {
        assertEquals(graph.findShortestPath("a", "d"), Arrays.asList("a", "b", "d"));
    }

    @Test
    public void return_empty_list_if_there_is_no_path() {
        assertEquals(graph.findShortestPath("b", "a").size(), 0);
    }

}
