package gfgalgo.module08hashing;

import java.util.*;

public class Prob_05UnionoofUnorderedArrays {
    public static int unionSize(int[] arr1, int[] arr2) {
        // Initiate the hashSet
        Set<Integer> hs = new HashSet<>();

        // add the items from the first array
        for (int x : arr1) {
            hs.add(x);
        }

        // add the items from the second array
        for (int x : arr2) {
            hs.add(x);
        }

        return hs.size();

    }

    public static void main(String[] args) {
        int arr1[] = new int[]{2, 8, 3, 5, 6};
        int arr2[] = new int[]{4, 8, 3, 6, 1};
        int m = arr1.length;
        int n = arr2.length;

        System.out.println(unionSize(arr1, arr2));
    }
}
