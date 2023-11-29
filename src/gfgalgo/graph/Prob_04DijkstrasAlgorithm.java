package gfgalgo.graph;
import java.util.*;

public class Prob_04DijkstrasAlgorithm {
    static final int V = 4;

    public static int[] dijikstra(int[][] graph, int src){
        int[] dist = new int[V]; // Array to store the shortest distances from the source vertex
        Arrays.fill(dist, Integer.MAX_VALUE);// Initialize distances to infinity
        dist[src] = 0;// Distance from the source vertex to itself is 0

        boolean[] fin = new boolean[V]; // Array to track whether a vertex is finalized

        for(int count=0; count<V-1; count++) {
            int u = -1;

            // Find the vertex with the minimum distance value that is not yet finalized

            for (int i = 0; i < V; i++) {
                if(!fin[i] && (u==-1 || dist[i] < dist[u])){
                    u=i;
                }
            }

            fin[u] = true; // Mark the selected vertex as finalized

            // Update the distance values of the adjacent vertices of the selected vertex

            for (int v = 0; v < V; v++) {
                // Update the distance if there is a shorter path through the selected vertex
                if(graph[u][v]!=0 && fin[v] == false) {
                    dist[v] = Math.min(dist[v], dist[u]+graph[u][v]);
                }

            }


        }

        return dist;// Return the array of shortest distances
    }

    public static void main(String[] args)
    {
        int graph[][] = new int[][] { { 0, 50, 100, 0},
                { 50, 0, 30, 200 },
                { 100, 30, 0, 20 },
                { 0, 200, 20, 0 },};

        for(int x: dijikstra(graph,0)){
            System.out.print(x+" ");
        }

    }
}
