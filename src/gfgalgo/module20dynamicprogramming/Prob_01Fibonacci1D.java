package gfgalgo.module20dynamicprogramming;

import java.util.Arrays;

public class Prob_01Fibonacci1D {
    static int[] memo;


    public static int fib(int n) {
        // check if the memo already contains the value
        if (memo[n] == -1) {
            int res;

            if (n == 0 || n == 1) {
                return n;
            } else {
                res = fib(n - 1) + fib(n - 2);
            }
            // update the memo table in every iteration
            memo[n] = res;
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;

        memo = new int[n + 1];

        Arrays.fill(memo, -1);
        System.out.println(fib(n));
    }
}
