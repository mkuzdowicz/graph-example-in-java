package com.kuzdowicz.algo.graphs.directed.unweighted;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DirectedUnweightedGraphTest {

    private String graphStrRepr1 = "a-b,a-c,c-e,b-d,e-b,e-d";
    private DirectedUnweightedGraph graph;

    @Test
    public void find_shortest_path_from_a_to_d() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(Arrays.asList("a", "b", "d"), graph.findShortestPath("a", "d"));
    }

    @Test
    public void return_empty_list_if_there_is_no_path() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(0, graph.findShortestPath("b", "a").size());
    }

    @Test
    public void find_shortest_path_from_a_to_d_for_impl_2() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(Arrays.asList("a", "b", "d"), graph.findShortestPathImpl2("a", "d"));
    }

    @Test
    public void return_empty_list_if_there_is_no_path_for_impl_2() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(0, graph.findShortestPathImpl2("b", "a").size());
    }

    @Test
    public void find_shortest_reaches_from_a_to_all_vertices() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(Arrays.asList("b", "c"), graph.shortestReachesFrom("a"));
    }

    @Test
    public void find_shortest_reaches_from_d_to_all_vertices() {
        graph = new DirectedUnweightedGraph(graphStrRepr1);
        assertEquals(new ArrayList<>(), graph.shortestReachesFrom("d"));
    }

    @Test
    public void return_vertices_inTopological_order() {
        graph = new DirectedUnweightedGraph("3-1,4-1,4-0,5-0,5-2,2-3");
        assertEquals(Arrays.asList("5", "4", "2", "3", "1", "0"), graph.getVerticesInTopologicalOrder());
    }

}
