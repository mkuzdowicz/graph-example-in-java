package com.kuzdowicz.algo.graphs.directed.unweighted;

import com.kuzdowicz.algo.graphs.directed.unweighted.directed.unweighted.DirectedUnweightedGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DirectedUnweightedGraphTest {

    private String graphStrRepr = "a-b,a-c,c-e,b-d,e-b,e-d";
    private DirectedUnweightedGraph graph = new DirectedUnweightedGraph(graphStrRepr);

    @Test
    public void find_shortest_path_from_a_to_d() {
        assertEquals(Arrays.asList("a", "b", "d"), graph.findShortestPath("a", "d"));
    }

    @Test
    public void return_empty_list_if_there_is_no_path() {
        assertEquals(0, graph.findShortestPath("b", "a").size());
    }

    @Test
    public void find_shortest_path_from_a_to_d_for_impl_2() {
        assertEquals(Arrays.asList("a", "b", "d"), graph.findShortestPathImpl2("a", "d"));
    }

    @Test
    public void return_empty_list_if_there_is_no_path_for_impl_2() {
        assertEquals(0, graph.findShortestPathImpl2("b", "a").size());
    }

    @Test
    public void find_shortest_reaches_from_a_to_all_vertices() {
        assertEquals(Arrays.asList("b", "c"), graph.shortestReachesFrom("a"));
    }

    @Test
    public void find_shortest_reaches_from_d_to_all_vertices() {
        assertEquals(new ArrayList<>(), graph.shortestReachesFrom("d"));
    }

}
