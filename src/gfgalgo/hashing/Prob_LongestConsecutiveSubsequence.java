package gfgalgo.hashing;

import java.util.HashSet;
import java.util.Set;

public class Prob_LongestConsecutiveSubsequence {
    /*
    Idea is
    1. Insert all the elements in a hash table
    2. then with 2n lookups we find the result
     */

    static int longestSub(int[] arr) {
        Set<Integer> hs = new HashSet<>();

        // add al the elements into the hashset
        for (int x : arr) {
            hs.add(x);
        }

        // loop through the hashset and look for the elements before and after t
        // then add it to the current length
        int res = 1;

        for (Integer x : hs) {
            if (hs.contains(x - 1) == false) {
                // then this is the new subsequence
                int curr = 1;
                while (hs.contains(x + curr)) {
                    curr++;
                }
                res = Math.max(curr, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 9, 3, 4, 2, 10, 13};
        System.out.println(longestSub(arr));
    }
}