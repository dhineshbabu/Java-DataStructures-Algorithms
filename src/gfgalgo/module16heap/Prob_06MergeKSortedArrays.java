package gfgalgo.module16heap;

import java.util.*;

// Definition of a class named Triplet
class Triplet implements Comparable<Triplet> {
    int val, aPos, vPos; // Variables to store value, array position, and value position

    // Constructor for the Triplet class
    Triplet(int v, int ap, int vp) {
        val = v; // Initialize value
        aPos = ap; // Initialize array position
        vPos = vp; // Initialize value position
    }

    // Implementation of the compareTo method from the Comparable interface
    public int compareTo(Triplet t) {
        // Compare the values of two Triplets
        if (val <= t.val)
            return -1; // Return -1 if the current Triplet's value is less than or equal to the other's
        else
            return 1; // Return 1 if the current Triplet's value is greater than the other's
    }
}


public class Prob_06MergeKSortedArrays {
    public static List<Integer> mergeArr(ArrayList<ArrayList<Integer>> arr) {
        List<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();

        for (int i = 0; i < arr.size(); i++)
            pq.add(new Triplet(arr.get(i).get(0), i, 0));

        while (pq.isEmpty() == false) {
            Triplet curr = pq.poll();
            res.add(curr.val);
            int ap = curr.aPos;
            int vp = curr.vPos;
            if (vp + 1 < arr.get(ap).size()) {
                pq.add(new Triplet(arr.get(ap).get(vp + 1), ap, vp + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        List<Integer> res = mergeArr(arr);

        System.out.println("Merged array is ");
        for (int x : res)
            System.out.print(x + " ");
    }
}
