package gfgalgo.module20dynamicprogramming;

public class Prob_04CoinChange {
    static int countWays(int[] coins, int s) {
        int n = coins.length;
        int[][] dp = new int[n + 1][s + 1];

        // Initialize all cells in the first column with 1 (base case: making 0 sum)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Initialize all cells in the first row (except dp[0][0]) with 0
        for (int j = 1; j <= s; j++) {
            dp[0][j] = 0;
        }

        // Fill the dp table iteratively
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                // Copy value from the row above
                dp[i][j] = dp[i - 1][j];

                // If current coin value is less than or equal to the current sum,
                // add the ways to make (j - coins[i - 1]) to the current cell
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        // Return the result stored in the bottom-right corner of the dp table
        return dp[n][s];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int s = 4;

        System.out.println(countWays(coins, 4));
    }
}
