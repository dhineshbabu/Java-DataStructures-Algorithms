package gfgalgo.module08hashing;

import java.util.Set;
import java.util.HashSet;

public class Prob_08SubArrayWithGivenSum {
    /*
    calculate the prefix sum
    for each iteration do given sum-prefixsum, if the result is already there in the hashset
        then subarray with given sum is available
     */

    static boolean isSum(int arr[], int n, int sum) {
        Set<Integer> s = new HashSet<Integer>();
        int pre_sum = 0;
        for (int i = 0; i < n; i++) {
            pre_sum += arr[i];
            if (pre_sum == sum)
                return true;
            if (s.contains(pre_sum - sum) == true)
                return true;

            s.add(pre_sum);
        }

        return false;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{5, 8, 6, 13, 3, -1};
        int sum = 22;
        int n = arr.length;

        System.out.println(isSum(arr, n, sum));

    }

}
