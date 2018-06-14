package com.terahertz.Dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;

public class Vertex implements Comparable<Vertex>{

    private final String name;
    final ArrayList<Edge> neighbors;
    LinkedList<Vertex> path;
    double minDistance = Double.POSITIVE_INFINITY;

    Vertex(String name){
        this.name = name;
        neighbors = new ArrayList<>();
        path = new LinkedList<>();
    }

    public String toString(){
        return name;
    }

    public int compareTo(Vertex other){
        return Double.compare(minDistance, other.minDistance);
    }
}
