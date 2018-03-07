package com.kuzdowicz.algo.graphs.directed.weighted;

import java.util.ArrayList;
import java.util.List;

class Vertex implements Comparable<Vertex> {

    private String data;
    private Vertex predecessor;
    private Integer minDistance = Integer.MAX_VALUE;
    private List<Edge> adjacent;

    Vertex(String data) {
        this.data = data;
        this.adjacent = new ArrayList<>();
    }

    String getData() {
        return data;
    }

    Vertex getPredecessor() {
        return predecessor;
    }

    List<Edge> getAdjacent() {
        return new ArrayList<>(adjacent);
    }

    void addAdjacentEdge(Vertex dest, int weight) {
        adjacent.add(new Edge(dest, weight));
    }

    Integer getMinDistance() {
        return minDistance;
    }

    void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    void setMinDistance(Integer minDistance) {
        this.minDistance = minDistance;
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

    @Override
    public int compareTo(Vertex v) {
        return getMinDistance().compareTo(v.getMinDistance());
    }
}
