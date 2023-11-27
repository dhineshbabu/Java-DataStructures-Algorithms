package datastructures.dynamicprogramming;

public class Prob_OptimalStrategyForGame {
    static int recursiveSolution(int[] arr, int i, int j){
        // base case - if only 2 coins are there
        if(i+1 == j) {
            return Math.max(arr[i], arr[j]);
        }

        return Math.max(
                (arr[i]+(Math.min(
                        recursiveSolution(arr, i+2, j),
                        recursiveSolution(arr, i+1, j-1)
                ))),
                arr[j]+ (Math.min(
                        recursiveSolution(arr, i, j-2),
                        recursiveSolution(arr, i+1, j-1)
                ))
        );
    }

    static int solDP(int[] arr, int n)
    {
        int dp[][] = new int[n][n];

        for(int i=0;i<n-1;i++)
        {
            dp[i][i+1]= Math.max(arr[i],arr[i+1]);
        }

        for(int gap =3; gap<n; gap = gap + 2)
        {
            for(int i=0; i+gap<n; i++)
            {
                int j = gap + i;

                dp[i][j] = Math.max((arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1])),
                        (arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2])));
            }
        }

        return dp[0][n-1];
    }

    public static void main (String[] args) {

        int n = 4;

        int arr[] = {20, 5, 4, 6};


        System.out.println(recursiveSolution(arr, 0, arr.length-1));
        System.out.println(solDP(arr, arr.length));


    }
}
