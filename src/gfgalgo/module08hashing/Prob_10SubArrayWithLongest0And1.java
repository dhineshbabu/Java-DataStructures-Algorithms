package gfgalgo.module08hashing;

import java.util.*;

public class Prob_10SubArrayWithLongest0And1 {
    /*
    input is binary array
    replace all the 0 in the array with -1
    now call the function to find the length of the largest sub-array with 0 sum
     */


    static int largestZeroSubarray(int arr[], int n) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0, maxLen = 0;

        // replace all the 0s with -1
        for (int i = 0; i < n; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;

        // lop through the array
        for (int i = 0; i < n; i++) {
            // prefix sum
            sum += arr[i];
            if (sum == 0)
                maxLen = i + 1;

            // if the key with sum+n alreay there
            // The sum + n expression is used to avoid collisions in the hash map and to ensure that each cumulative sum has a unique identifier.
            if (hm.containsKey(sum + n) == true) {
                if (maxLen < i - hm.get(sum + n))
                    maxLen = i - hm.get(sum + n);

            } else hm.put(sum + n, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1};
        int len = arr.length;

        System.out.println(largestZeroSubarray(arr, len));
    }
}
