package datastructures.dynamicprogramming;

public class Prob_CoinChange   {
    static int countWays(int[] coins, int s){
        int n = coins.length;
        int[][] dp = new int[n+1][s+1];

        // initialize all the first column with 1
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }

        // initialize all the first rows with 0
        for(int j=1; j<=s; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=s; j++) {
                dp[i][j] = dp[i-1][j];
                if(coins[i-1] <= j) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }

        }
        return dp[n][s];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int s = 4;

        System.out.println(countWays(coins, 4));
    }
}
