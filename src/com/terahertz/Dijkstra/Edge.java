package com.terahertz.Dijkstra;

class Edge {

    final Vertex target;
    final double weight;
    Edge(Vertex v, double weight){
        this.target = v;
        this.weight = weight;
    }

}
