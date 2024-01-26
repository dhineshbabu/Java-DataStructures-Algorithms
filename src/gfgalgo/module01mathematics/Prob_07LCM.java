package gfgalgo.module01mathematics;

public class Prob_07LCM {

    /*

    idea is to use the below technique


     */
    // Method to calculate the Greatest Common Divisor (GCD) using Euclidean algorithm
    public static int gcd(int a, int b) {
        // Base case: if b is zero, the GCD is a (Euclidean algorithm)
        if (b == 0) {
            return a;
        } else {
            // Recursive case: call gcd with b and a%b
            return gcd(b, a % b);
        }
    }

    // Method to calculate the Least Common Multiple (LCM) using GCD
    public static int lcm(int a, int b) {
        // LCM is calculated as (a * b) / GCD(a, b)
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(4, 6)); // 12
    }
}
