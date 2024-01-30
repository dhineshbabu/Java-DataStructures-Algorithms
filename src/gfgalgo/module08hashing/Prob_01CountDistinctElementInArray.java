package gfgalgo.module08hashing;

import java.util.Arrays;
import java.util.HashSet;

public class Prob_01CountDistinctElementInArray {
    /*
    Create an hashset and retutn the final size after adding all the array elements
     */
    static int count(int[] arr, Integer[] arr1) {
        HashSet<Integer> hs = new HashSet<>();
        // we can also use in constructor
        HashSet<Integer> hs1 = new HashSet<>(Arrays.asList(arr1));
        for (int i : arr) {
            hs.add(i);
        }

        return hs.size();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30};

        Integer[] arr1 = {10, 20, 10, 20, 30};
        System.out.println(count(arr, arr1));
    }
}
