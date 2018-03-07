package com.kuzdowicz.algo.graphs.directed.weighted;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String data;
    private Vertex predecessor;
    private Integer distance = Integer.MAX_VALUE;
    private List<Edge> adjacent;

    public Vertex(String data) {
        this.data = data;
        this.adjacent = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public List<Edge> getAdjacent() {
        return new ArrayList<>(adjacent);
    }

    public void addAdjacentEdge(Vertex dest, int weight) {
        adjacent.add(new Edge(dest, weight));
    }

    public Integer getDistance() {
        return distance;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return getData() + " => " + getAdjacent() + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
