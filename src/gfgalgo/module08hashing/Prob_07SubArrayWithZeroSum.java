package gfgalgo.module08hashing;

import java.util.HashSet;

public class Prob_07SubArrayWithZeroSum {
    /*
       idea is to use prefix and hashing technique
       Navigate through the array and calculate the prefix sum and add it to the hash
       if the same prefix sum already available then subarray
     */

    static boolean isSubArray(int[] arr) {
        int n = arr.length;

        // createa a hashset
        HashSet<Integer> hs = new HashSet<>();

        int preSum = 0;

        // calcualte the prefix
        for (int i = 0; i < n; i++) {

            preSum += arr[i];

            //if prefix is 0 then we dont need to check the hashset

            if (preSum == 0) return true;

            if (hs.contains(preSum)) {
                return true;
            } else {
                hs.add(preSum);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] arr = {-3, 4, -3, -1, 1};
        System.out.println(isSubArray(arr));
    }
}
