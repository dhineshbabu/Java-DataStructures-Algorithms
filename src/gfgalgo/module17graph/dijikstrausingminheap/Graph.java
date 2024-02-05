package gfgalgo.module17graph.dijikstrausingminheap;

import java.util.*;

public class Graph {
    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private final int vertices;
    private final List<List<Node>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(this.vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        this.adjacencyList.get(source).add(new Node(destination, weight));
    }

    public void dijkstra(int startVertex) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Using minHeap to maintain vertices with the minimum distance at the front
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Add the start vertex to the minHeap with distance 0
        minHeap.add(new Node(startVertex, 0));
        distance[startVertex] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int newDistance = distance[currentVertex] + neighbor.weight;

                // Relaxation step
                if (newDistance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDistance;
                    minHeap.add(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        // Print the shortest distances from the start vertex to all other vertices
        System.out.println("Shortest Distances from Vertex " + startVertex + " to Other Vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To Vertex " + i + ": " + distance[i]);
        }
    }


    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 7);
        graph.addEdge(4, 3, 1);
        graph.addEdge(4, 5, 8);

        // Running Dijkstra's algorithm from vertex 0
        System.out.println("Dijkstra's Shortest Path Algorithm:");
        graph.dijkstra(0);
    }
}
