package gfgalgo.hashing;

import java.util.*;

public class Prob_CountDistinctElementInEveryWindow {
    /*
    count distinct element in every window
    createa a hashmap
    for each iteration calcualte the freq window and udpate
    for the next window, reduce hte count for first element and increase the count for the current new element inthe window
    get the size of the map in each window to get the distinct count
    print the size of the map
     */

    public static void main (String[] args)
    {
        int arr[] = new int[]{10, 10, 5, 3, 20, 5};

        int n = arr.length;
        int k=4;
        printDistinct(arr, n, k);

    }

    static void printDistinct(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> m=new HashMap<>();

        // for first window

        for (int i = 0; i < k; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(m.size()+" ");

        // from 2nd window
        for (int i = k; i < n; i++) {

            // reduce the first element inthe previous window count
            m.put(arr[i - k],  m.get(arr[i - k]) - 1);

            // if it is 0 then remove the number altogether form the map
            if (m.get(arr[i - k]) == 0) {
                m.remove(arr[i-k]);
            }

            // add the new element in the current window
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);

            // print the current size
            System.out.print(m.size()+" ");
        }
    }
}

