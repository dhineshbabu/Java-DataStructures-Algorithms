package datastructures.disjointset;

import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class disjointset {
    static int parent[];
    static int ranks[];


    static void initialize()
    {
        for(int i=0; i<parent.length; i++)
        {
            parent[i]=i;
        }
    }

    static int find(int x)
    {

        /// returning the root node
        if(parent[x]==x)
            return x;
        else
            return find(parent[x]);

    }

    // path compression
    static int findPC(int x)
    {
        if(parent[x]==x)
            return x;

        parent[x] = findPC(parent[x]);

        return parent[x];

    }

    static void union(int x, int y)
    {
        int x_rep = find(x);
        int y_rep = find(y);

        if(x_rep==y_rep)
            return;

        parent[y_rep]=x_rep;
    }

    // union by rank
    // smaller height tree will be child of higher height tree
    // overall rank will not be increased

    static void unionByRank(int x, int y)
    {
        int x_rep = find(x);
        int y_rep = find(y);

        if(x_rep==y_rep)
            return;

        if(ranks[x_rep]<ranks[y_rep])
            parent[x_rep] = y_rep;

        else if(ranks[y_rep]<ranks[x_rep])
            parent[y_rep]=x_rep;

        else
        {
            parent[y_rep] = x_rep;

            ranks[x_rep]++;
        }



    }


    public static void main (String[] args) {

        int n = 5;

        parent = new int[5];

        initialize();

        union(0, 2);
        union(0, 4);

        out.println(find(4));
        out.println(find(3));
    }
}

