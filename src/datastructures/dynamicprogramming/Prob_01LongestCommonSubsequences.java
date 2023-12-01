package datastructures.dynamicprogramming;

import java.util.Arrays;

public class Prob_01LongestCommonSubsequences {
    // using memoization technique

    // initialize memo array
    static  int[][] memo;

    static int lcs(String s1, String s2, int n, int m) {

        // if the value already calculated then return the value
        if(memo[n][m] != -1) {
            return memo[n][m];
        }

        // case if any of the count became 0
        if(m==0 || n==0) {
            memo[n][m] = 0;
        }

        else {
            // check from the last value
            if(s1.charAt(n-1) ==  s2.charAt(m-1)){
                memo[n][m] = 1 + lcs(s1, s2, n-1, m-1);
            } else {
                memo[n][m] = Math.max(lcs(s1,s2,n-1, m),
                                        lcs(s1,s2,n, m-1));
            }
        }

        return memo[n][m];

    }

    // using tabulation method

    static int lcs(String s1, String s2){
        int m = s1.length(), n = s2.length();

        // initiate dp array
        int[][] dp = new int[m+1][n+1];

        // fill first row with 0
        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }
        // fill first column with 0
        for(int j=0; j<=n; j++){
            dp[0][j] = 0;
        }

        //do the tabulation and get the final value in the amtrix
        for(int i=1; i<=m; i++){
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];  // add 1 to the diagonal value
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
     return dp[m][n]; // return final value
    }

    public static void main(String[] args) {
        String s1 = "AXYZ", s2 = "BAZ";

        int n = s1.length(), m = s2.length();

        memo = new int[n+1][m+1];

        // fill the array with -1
        for(int[] i: memo) {
            Arrays.fill(i, -1);
        }

        System.out.println(lcs(s1, s2, n, m));

    }

}