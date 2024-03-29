package gfgalgo.module20dynamicprogramming;

public class Prob_02FibonacciTabulation {
    public static int fibonaaci(int n) {
        int[] f = new int[n + 1];

        // initialize the tables
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonaaci(10));
    }
}
