package gfgalgo.module02bitmagic;

public class Prob_03CheckIfNumberPowerOf2 {
    public static boolean isPow2(int n) {
        // using Brian Kerningham's algorithm
        // if the number is power of 2 then bitwise &  of n and n-1 will give 0
        if (n == 0) return false;

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPow2(8));
        System.out.println(isPow2(7));
        System.out.println(isPow2(2));
    }
}
