package gfgalgo.module20dynamicprogramming.yt;


public class Prob_02CoinChange {

    // Method to calculate the minimum number of coins needed to make up the given amount
    int coinChange(int[] coins, int amount) {

        // Check edge case: if the amount is less than 1, no coins are needed
        if (amount < 1) return 0;

        // Create DP array to store minimum coins needed for each amount from 0 to the target amount
        int[] minCoinsDP = new int[amount + 1];

        // Iterate through amounts from 1 to the target amount
        for (int i = 1; i <= amount; i++) {

            // Initialize the minimum coins needed to a large value
            minCoinsDP[i] = Integer.MAX_VALUE;

            // Try each coin to find the minimum number of coins needed for the current amount
            for (int coin : coins) {
                // Check if the current coin can contribute to the amount and if using it is optimal
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE)
                    // Update the minimum coins needed for the current amount
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
            }
        }

        // If the value at the target amount is still the initialized large value, it means no valid combination exists
        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
    }

}