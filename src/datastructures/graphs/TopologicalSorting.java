package datastructures.graphs;
import java.util.*;

public class TopologicalSorting {
    /*

     -- This is also called Khan's Algorithm
    BFS Based Solution:
        * Store indegree of every vertex
        * Create a queue
        * Add all 0 indegree vertices to the q
        * then follow the samesteps as BFS
    * we need to create an array indegree
     */

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V)
    {

        // update the indegree array
        int[] in_degree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }

        Queue<Integer> q=new LinkedList<>();

        // step 1 - add all the vertices with indegree as 0
        for (int i = 0; i < V; i++)
            if (in_degree[i] == 0)
                q.add(i);


        while (q.isEmpty()==false) {
            int u = q.poll();
            // print the current queue element
            System.out.print(u+" ");

            // each of the connected vertex, reduce the indegree count
            // if it becomes 0 add it to the queue
            for (int x: adj.get(u))
                if (--in_degree[x] == 0)
                    q.add(x);
        }
    }

    // cycle detection with Khan's alogrithm
    // topological sorting will work only for acyclic graphs
    // maintain a count variable- after processing all the vertices count == count(v) then no cycle

    static void cycleTopologicalSort(ArrayList<ArrayList<Integer>> adj, int V)
    {
        int[] in_degree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (in_degree[i] == 0)
                q.add(i);

        int count=0;
        while (q.isEmpty()==false) {
            int u = q.poll();


            for (int x: adj.get(u))
                if (--in_degree[x] == 0)
                    q.add(x);

            count++;
        }

        // This is the key validation for this

        if (count != V) {
            System.out.println("There exists a cycle in the graph");
        }
        else{
            System.out.println("There exists no cycle in the graph");
        }
    }

    /*
    DFS based topological sort
    steps
    create an empty stack
    For every vertex u
        if u is not visited
         DFS(u, st)
            {
            mark u as visited
            for every adj v of u
                if(v is not visited)
                    DFS(v, st)
            }
            push u to st
     */

    static void DFSTSRec(ArrayList<ArrayList<Integer>> adj, int u,Stack<Integer> st, boolean visited[])
    {
        visited[u]=true;

        for(int v:adj.get(u)){
            if(visited[v]==false)
                DFSTSRec(adj,v,st,visited);
        }
        st.push(u);
    }


    static void topologicalSortDFS(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean[] visited=new boolean[V];
        for(int i = 0;i<V; i++)
            visited[i] = false;
        Stack<Integer> st = new Stack<Integer>();

        for(int u=0;u<V;u++){
            if(visited[u]==false){
                DFSTSRec(adj,u,st,visited);
            }
        }

        /// print the elements

        while (st.empty() == false)
            System.out.print(st.pop() + " ");

    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);

        System.out.println("Following is a Topological Sort of");
        topologicalSort(adj,V);
        System.out.println();
        topologicalSortDFS(adj, V);
    }
}
