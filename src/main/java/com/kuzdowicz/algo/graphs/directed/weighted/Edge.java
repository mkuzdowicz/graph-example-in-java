package com.kuzdowicz.algo.graphs.directed.weighted;

public class Edge {

    private Vertex targetVertex;
    private Integer weight;

    Edge(Vertex targetVertex, Integer weight) {
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return targetVertex.getData() + ": " + weight;
    }
}
