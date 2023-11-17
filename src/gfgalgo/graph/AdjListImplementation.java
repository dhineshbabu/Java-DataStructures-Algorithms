package gfgalgo.graph;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjListImplementation {
    /*
    can be created with ArrayList<ArrayList<Integer>>
     */

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // need to udpate the adjeacency list for both the vertices
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printList(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0; i<adj.size(); i++) {
            for(int j=0; j<adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {
        // Initiate a queue
        Queue<Integer> q = new LinkedList<>();

        // add start index manually
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node+ " ");

            for(int v: adj.get(node)) {
                if(visited[v] == false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // this is to print multiple recursive calls for disconnected grapjs

    static void BFSDisconnected(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];

        // initiated visited with False

        for (int i = 0; i < v; i++) {
            // if not visited then call the BFS
            if(visited[i] == false){
                BFS(adj,i, visited);
            }

        }
    }


    //DEPTH FIRST SEARCH
    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s+ " ");

        for(int u: adj.get(s)) {
            if(visited[u] == false) {
                // call recursively
                DFSRec(adj, u, visited);
            }
        }
    }

    // trigger
    static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V];
        DFSRec(adj, s, visited);
    }


    // Prob_Shortest Path In an Undirected Graph
    static void shortestPathBFS(ArrayList<ArrayList<Integer>> adj,int V,int s, int[] dist)
    {
        boolean[] visited=new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        Queue<Integer> q=new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while(q.isEmpty()==false)
        {
            int u = q.poll();

            for(int v:adj.get(u)){
                if(visited[v]==false){
                    dist[v]=dist[u]+1;
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }


    // Prob_Cycle Detection - Undirected Graph
    // we need to maintain an additional variable called "parent"

    static boolean cycleDFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited, int parent)
    {
        visited[s]=true;

        for(int u:adj.get(s)){
            if(visited[u]==false){
                if(cycleDFSRec(adj,u,visited,s)==true)
                {return true;}}
            else if(u!=parent)
            {return true;}
        }
        return false;
    }

    static boolean cycleDetectionDFS(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited=new boolean[V];
        for(int i = 0; i<V; i++)
            visited[i] = false;

        for(int i=0;i<V;i++){
            if(visited[i]==false)
                if(cycleDFSRec(adj,i,visited,-1)==true)
                    return true;
        }
        return false;
    }

    // Prob_Cycle Detection - Directed Graph
    // We need to maintain additional array - rect for recursion call stack

    static boolean cuycleDirectedDFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited, boolean[] recSt)
    {
        visited[s]=true;
        recSt[s]=true;

        for(int u:adj.get(s)){
            if(visited[u]==false && cuycleDirectedDFSRec(adj,u,visited,recSt)==true)
            {return true;}
            else if(recSt[u]==true)
            {return true;}
        }
        recSt[s]=false;
        return false;
    }

    static boolean cuycleDirectedDFS(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited=new boolean[V];
        for(int i = 0; i<V; i++)
            visited[i] = false;

        boolean[] recSt=new boolean[V];
        for(int i = 0; i<V; i++)
            recSt[i] = false;

        for(int i=0;i<V;i++){
            if(visited[i]==false)
                if(cuycleDirectedDFSRec(adj,i,visited,recSt)==true)
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            // add all the arrayList for each edge
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);

        printList(adj);

        System.out.println("Following is Breadth First Traversal: ");
        BFSDisconnected(adj,v);
        System.out.println();

        System.out.println("Following is Depth First Traversal: ");
        DFS(adj,v, 0);
        System.out.println();
        System.out.println("FOr second disconnected");
        DFS(adj,v, 4);

        // shortest path from 0
        // we need to maintain a distance array
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MIN_VALUE;
        }
        dist[0] = 0;
        shortestPathBFS(adj, v, 0, dist);
        System.out.println();

        // print all the shortest path
        for (int i = 0; i < v; i++) {
            System.out.print(dist[i]+ " ");
        }

        System.out.println();
        System.out.println("Cycle Detection");

        if(cycleDetectionDFS(adj,v)==true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");


        // cycle graph directed
        if(cuycleDirectedDFS(adj,v)==true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");

    }
}
