package gfgalgo.module20dynamicprogramming;

public class Prob_MinJumpsToReachEnd {
    /*
    we can solve with either recursion or dp
     */

    // recursion approach
    static int minJumps(int[] arr, int n) {
        // base case
        if (n == 1) return 0;

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] >= n - 1) {
                int sub_res = minJumps(arr, i + 1);
                if (sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }

    // DYnamic programming approach
    static int minJumpsDP(int[] arr, int n) {
        // intialize DP array with index[0] = 0
        int[] dp = new int[n];
        //set the first value to 0
        dp[0] = 0;


        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                // calculate for each sub jumps for the current position from previous elements
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }

            }

        }

        // final element will have the result
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 2, 1}, n = 6;


        System.out.println(minJumpsDP(arr, n));


    }
}
