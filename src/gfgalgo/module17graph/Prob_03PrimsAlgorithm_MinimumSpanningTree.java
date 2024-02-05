package gfgalgo.module17graph;

import java.util.*;

public class Prob_03PrimsAlgorithm_MinimumSpanningTree {
    /*
    this is only for undirected graph connected
    spanning tree - v vertices and will have v-1 edges

    Prims algorithm:
        Two sets
            1. In MST
            2. Not yet in MST
     */

    static final int V = 4;

    // Function to find the minimum spanning tree using Prim's algorithm
    public static int primMST(int graph[][]) {
        int[] dist = new int[V]; // Key values used to pick minimum weight edge
        int res = 0; // Total weight of the minimum spanning tree
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize key values to infinity
        boolean[] mSet = new boolean[V]; // To represent whether a vertex is included in the MST or not
        dist[0] = 0; // Start with the first vertex

        for (int count = 0; count < V; count++) {
            int u = -1; // Initialize u to an invalid value

            // Find the vertex with the minimum key value that is not yet included in the MST
            for (int i = 0; i < V; i++)
                if (!mSet[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;

            mSet[u] = true; // Include the selected vertex in the MST
            res += dist[u]; // Add the key value of the selected vertex to the total weight

            // Update key values of the adjacent vertices of the selected vertex
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mSet[v])
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
        }

        return res; // Return the total weight of the minimum spanning tree
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int graph[][] = new int[][]{{0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0},};

        // Print the total weight of the minimum spanning tree
        System.out.print(primMST(graph));
    }


}
