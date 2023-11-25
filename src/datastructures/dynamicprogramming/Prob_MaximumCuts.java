package datastructures.dynamicprogramming;

public class Prob_MaximumCuts {
    /*
    objective is to maximum number of pieces

     */

    static int maxCuts(int n, int a, int b, int c){
        // initialize dp array
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <=n; i++) {
            dp[i] = -1;

            if(i-a >=0) dp[i] = Math.max(dp[i], dp[i-a]);
            if(i-b >=0) dp[i] = Math.max(dp[i], dp[i-b]);
            if(i-c >=0) dp[i] = Math.max(dp[i], dp[i-c]);

            if(dp[i] != -1) dp[i]++;
        }

        // final element in the aray will hold the meximum possible cuts
        return dp[n];
    }

    public static void main (String[] args)
    {
        int n = 5, a = 1, b = 2, c = 3;

        System.out.println(maxCuts(n, a, b, c));


    }
}
