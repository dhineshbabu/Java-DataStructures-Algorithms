package datastructures.dynamicprogramming;

import java.util.PriorityQueue;

public class Prob_EditDistance {
    /*
    convert source to destination string using
        with only 3 operation
        an insert
        a delete
        a replace
        find min operations to convert s1 to s2
     */

    // using recursive solution
    static int eDRec(String s1, String s2, int m, int n) {

        if(m==0) return n;
        if(n==0) return m;

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            return eDRec(s1, s2, m-1, n-1);
        } else {
            return 1 + Math.min(
                    eDRec(s1,s2,m,n-1),
                    Math.min(eDRec(s1,s2,m-1,n),
                    eDRec(s1,s2, m-1, n-1))
            );
        }
    }

    // using dynamic programming - tabulation

    static int edDP(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <=m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <=n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // take the diagonal result
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + (Math.min(dp[i-1][j],
                            Math.min(dp[i][j-1], dp[i-1][j-1])));
                }
            }

        }

    return dp[m][n]; // final element wil have the value
    }


    public static void main(String[] args) {
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        System.out.println(eDRec(s1,s2,s1.length(), s2.length()));
        System.out.println(edDP(s1,s2,s1.length(), s2.length()));
    }
}
