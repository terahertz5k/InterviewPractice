package com.terahertz.Dijkstra;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] arg){

        Dijkstra obj = new Dijkstra();

        // Create a new graph.
        Graph g = new Graph(9);

        // Add the required edges.
        g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
        g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
        g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9);
        g.addEdge(4, 3, 9); g.addEdge(4, 5, 10);
        g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
        g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
        g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);

        // Calculate Dijkstra.
        obj.calculate(g.getVertex(0));

        // Print the minimum Distance.
        for(Vertex v:g.getVertices()){
            System.out.print("Vertex - "+v+" , Dist - "+ v.minDistance+" , Path - ");
            for(Vertex pathvert:v.path) {
                System.out.print(pathvert+" ");
            }
            System.out.println(""+v);
        }

    }

    public void calculate(Vertex source){

        // Algo:
        // 1. Take the unvisited node with minimum weight.
        // 2. Visit all its neighbours.
        // 3. Update the distances for all the neighbours (In the Priority Queue).
        // Repeat the process till all the connected nodes are visited.

        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.add(source);

        while(!queue.isEmpty()){
            Vertex u = queue.poll();
            System.out.println(u);
            for(Edge neighbor : u.neighbors){
                Double newDist = u.minDistance + neighbor.weight;
                if(newDist < neighbor.target.minDistance){
                    //Remove the node to edit the distance
                    queue.remove(neighbor.target);
                    neighbor.target.minDistance = newDist;

                    //Take the path until now and add the new node
                    neighbor.target.path = new LinkedList<Vertex>(u.path);
                    neighbor.target.path.add(u);

                    //Re-add the node with the new distance
                    queue.add(neighbor.target);
                    System.out.println(neighbor.target);
                }
            }
        }
    }


}
