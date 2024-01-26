package gfgalgo.module01mathematics;

public class Prob_05PrimeNumber {
    public static boolean isPrime(int n) {
        // Special case: 1 is not a prime number
        if (n == 1) {
            return false;
        }

        // Special cases: 2 and 3 are prime numbers
        if (n == 2 || n == 3) {
            return true;
        }

        // Check divisibility by 2 or 3
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check divisibility by numbers of the form 6k ± 1, up to the square root of n
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                // If n is divisible by i or i+2, then it's not a prime number
                return false;
            }
        }

        // If no divisor is found, n is a prime number
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2357));
    }

}
