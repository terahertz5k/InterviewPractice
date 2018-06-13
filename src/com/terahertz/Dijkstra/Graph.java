package com.terahertz.Dijkstra;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    public Graph(int numberOfVerticies){
        vertices = new ArrayList<>(numberOfVerticies);
        for(int i = 0; i < numberOfVerticies; i++){
            vertices.add(new Vertex("v"+Integer.toString(i)));
        }
    }

    public void addEdge(int src, int dest, int weight){
        Vertex s = vertices.get(src);
        Edge e = new Edge(vertices.get(dest), weight);
        s.neighbors.add(e);
    }

    public ArrayList<Vertex> getVertices(){
        return vertices;
    }

    public Vertex getVertex(int vert){
        return vertices.get(vert);
    }
}
