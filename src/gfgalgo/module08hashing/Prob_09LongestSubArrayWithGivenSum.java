package gfgalgo.module08hashing;

import java.util.*;

public class Prob_09LongestSubArrayWithGivenSum {
    /*
    we can leverage hashmap to store all the prefix sum
    for each prefix sum , check if the sum-prefix sum avaiilable in the map
        if yes then track the length in a result variable
    get the max value of the result at the end of the loop
    if there is duplicate sum-prefixsum value then dont replace in the map we are looking for a longer subarray
     */

    static int maxLen(int[] arr, int sum) {
        // Create a HashMap to store the cumulative sum (preSum) and its corresponding index
        Map<Integer, Integer> m = new HashMap<>();
        // Initialize variables for cumulative sum, result length, and result
        int preSum = 0, res = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the cumulative sum
            preSum += arr[i];
            // Check if the cumulative sum is equal to the target sum
            if (preSum == sum) {
                // Update the result length to the current index + 1
                res = i + 1;
            }

            // If the cumulative sum is not already in the map, add it along with its index
            if (!m.containsKey(preSum)) {
                m.put(preSum, i);
            }

            // If (cumulative sum - target sum) is present in the map, update the result length
            if (m.containsKey(preSum - sum)) {
                // Calculate the new length and update the result if it's greater
                res = Math.max(res, i - m.get(preSum - sum));
            }
        }

        // Return the final result length
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5, 8, -4, -4, 9, -2, 2};
        int n = arr.length;
        int sum = 0;

        System.out.println(maxLen(arr, sum));

    }
}
