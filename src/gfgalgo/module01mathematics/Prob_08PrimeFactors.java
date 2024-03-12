package gfgalgo.module01mathematics;

public class Prob_08PrimeFactors {
    // Method to print the prime factors of a given number
    static void printPrimeFactors(int n) {
        // Special case: 1 and non-positive numbers have no prime factors
        if (n <= 1) {
            return;
        }

        // Check divisibility by 2
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n = n / 2;
        }

        // Check divisibility by 3
        while (n % 3 == 0) {
            System.out.print(3 + " ");
            n = n / 3;
        }

        // Check divisibility by numbers of the form 6k ± 1, up to the square root of n
        for (int i = 5; i * i <= n; i = i + 6) {
            // Check divisibility by i
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }

            // Check divisibility by i + 2
            while (n % (i + 2) == 0) {
                System.out.print((i + 2) + " ");
                n = n / (i + 2);
            }
        }

        // If n is still greater than 3, it is a prime factor
        if (n > 3) {
            System.out.print(n + " ");
        }

        // Print a new line after printing prime factors
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 450;

        printPrimeFactors(n);

        n = 16;
        printPrimeFactors(n);

    }
}
