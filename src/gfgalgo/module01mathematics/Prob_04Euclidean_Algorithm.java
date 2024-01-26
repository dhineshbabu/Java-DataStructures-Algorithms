package gfgalgo.module01mathematics;

public class Prob_04Euclidean_Algorithm {
    // Method to calculate the greatest common divisor (GCD) using Euclidean algorithm
    public static int gcd(int a, int b) {
        // Base case: if b is zero, the GCD is a (Euclidean algorithm)
        if (b == 0) {
            return a;
        } else {
            // Recursive case: call gcd with b and a%b
            return gcd(b, a % b);
        }
    }
    // similarly for LCM = (a*b) / gcd(a,b)

    public static void main(String[] args) {
        System.out.println(gcd(12, 15));  //3
    }
}
