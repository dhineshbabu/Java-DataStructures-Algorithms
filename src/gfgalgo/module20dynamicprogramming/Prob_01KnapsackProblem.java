package gfgalgo.module20dynamicprogramming;

public class Prob_01KnapsackProblem {

    // recursive approach
    static int knapSack(int W, int[] wt, int[] val, int n) {
        //base case
        if (n == 0 || W == 0) return 0;

        // else consider from the last element
        if (wt[n - 1] > W) {
            // then remove the last item and recurse
            return knapSack(W, wt, val, n - 1);
        } else {
            // else there are 2 cases, either consider the item or don't consider the item
            return Math.max(
                    knapSack(W, wt, val, n - 1),
                    val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1) // subtract the element as we added the
            );
        }
    }

    // for DP , we will have dp matrix
    static int knapsackDP(int W, int[] wt, int[] val, int n) {
        // initialize the DP matrix
        int[][] dp = new int[n + 1][W + 1];

        // fill the values for first row and first column in dp array
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // consider the above recursive cases and fill the dp matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            // consider
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            // not consider
                            dp[i - 1][j]
                    );
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        int n = 4;


        System.out.println(knapsackDP(W, wt, val, n));


    }
}
