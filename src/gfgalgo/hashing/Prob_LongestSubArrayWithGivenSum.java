package gfgalgo.hashing;

import java.util.*;

public class Prob_LongestSubArrayWithGivenSum {
    /*
    we can leverage hashmap to store all the prefix sum
    for each prefix sum , check if the sum-prefix sum avaiilable int he map
        if yes then track the length in a result variable
    get the max value of the result at the end of the loop
    if there is duplicate sum-prefixsum value then dont replace in the map we are looking for a longer subarray
     */

    static int maxLen(int[] arr, int sum) {
        Map<Integer, Integer> m = new HashMap<>();
        int preSum = 0, res = 0;

        for (int i = 0; i < arr.length; i++) {
            // calcualte the presum
            preSum += arr[i];
            // check if preSum is sum
            if(preSum == sum) {
                res = i+1;
            }
            if(m.containsKey(preSum) == false) {
                m.put(preSum, i);
            }

            // if presum-sum alrady there

            if(m.containsKey(preSum - sum)) {
                res = Math.max(res, i-m.get(preSum - sum));
            }
        }

        return res;
    }

    public static void main (String[] args)
    {
        int arr[] = new int[]{5, 8, -4, -4, 9, -2, 2};
        int n = arr.length;
        int sum = 0;

        System.out.println(maxLen(arr, sum));

    }
}
