package datastructures.dynamicprogramming;

public class Prob_MaxSumWithNoTwoConsecutiveElem {
    // recursive solution
    static int maxSumRec(int[] arr, int n) {
        // base cases
        if(n==1) return arr[0];
        else if(n==2) return Math.max(arr[0], arr[1]);
        else {
            return Math.max(maxSumRec(arr, n-1), maxSumRec(arr, n-2)+arr[n-1]);
        }
    }

    // dp approach
    static int maxSumDP(int[] arr, int n) {
        if(n==0) return arr[0];
        int[] dp = new int[n+1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0],arr[1]);
        for (int i = 3; i <=n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i-1]);
        }
        return dp[n];
    }

    public static void main (String[] args) {

        int n = 5, arr[]= {10, 20, 30, 40, 50};

        System.out.println(maxSumDP(arr, n));

    }
}
