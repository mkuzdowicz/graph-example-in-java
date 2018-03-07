package com.kuzdowicz.algo.graphs.directed.weighted;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DirectedWeightedGraphTest {

    private DirectedWeightedGraph graph;

    @Test
    public void find_shortest_path_from_a_to_c_1() {
        graph = new DirectedWeightedGraph("a-1-b,b-1-c,a-10-c");
        assertEquals(Arrays.asList("a", "b", "c"), graph.findShortestPath("a", "c"));
    }

    @Test
    public void find_shortest_path_from_a_to_c_2() {
        graph = new DirectedWeightedGraph("a-1-b,b-1-c,a-1-c");
        assertEquals(Arrays.asList("a", "c"), graph.findShortestPath("a", "c"));
    }
}
