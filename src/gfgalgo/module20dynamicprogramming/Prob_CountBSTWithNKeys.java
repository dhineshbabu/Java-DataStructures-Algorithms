package gfgalgo.module20dynamicprogramming;

public class Prob_CountBSTWithNKeys {
    static int countBSTs(int n) {
        int[] dp = new int[n + 1];

        //initialize dp value
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;

            // another loop for calculating the sum until this number
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(countBSTs(n));


    }
}
