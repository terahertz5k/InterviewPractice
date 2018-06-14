package com.terahertz.Dijkstra;

import java.util.ArrayList;

class Graph {
    private final ArrayList<Vertex> vertices;
    Graph(int numberOfVerticies){
        vertices = new ArrayList<>(numberOfVerticies);
        for(int i = 0; i < numberOfVerticies; i++){
            vertices.add(new Vertex("v"+Integer.toString(i)));
        }
    }

    void addEdge(int src, int dest, int weight){
        Vertex s = vertices.get(src);
        Edge e = new Edge(vertices.get(dest), weight);
        s.neighbors.add(e);
    }

    ArrayList<Vertex> getVertices(){
        return vertices;
    }

    Vertex getVertex(int vert){
        return vertices.get(vert);
    }
}
