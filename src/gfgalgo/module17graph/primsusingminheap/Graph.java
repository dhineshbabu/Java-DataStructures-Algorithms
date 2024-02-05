package gfgalgo.module17graph.primsusingminheap;

import java.util.*;

public class Graph {
    static class Edge {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private final int vertices;
    private final List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        this.adjacencyList.get(source).add(new Edge(destination, weight));
        this.adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public void primMST() {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        boolean[] inMST = new boolean[vertices];
        Arrays.fill(inMST, false);

        // Start Prim's algorithm from the first vertex
        int startVertex = 0;
        inMST[startVertex] = true;
        minHeap.addAll(adjacencyList.get(startVertex));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int currentVertex = edge.destination;

            // Skip if the destination is already in MST
            if (inMST[currentVertex]) {
                continue;
            }

            // Include the current edge in the MST
            inMST[currentVertex] = true;

            // Print the edge or perform any other desired operation
            System.out.println("Edge: " + startVertex + " - " + currentVertex + "  Weight: " + edge.weight);

            // Add all adjacent edges of the current vertex to the minHeap
            minHeap.addAll(adjacencyList.get(currentVertex));
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Running Prim's algorithm
        System.out.println("Minimum Spanning Tree (Prim's Algorithm):");
        graph.primMST();
    }
}
