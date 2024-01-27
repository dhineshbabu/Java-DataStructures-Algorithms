package gfgalgo.module01mathematics;

public class Prob_09AllDivisors {
    // Method to print the divisors of a given number
    public static void printDivisors(int n) {
        // Iterate through numbers i up to the square root of n
        // These are the divisors smaller than or equal to the square root
        int i;
        for (i = 1; i * i < n; i++) {
            // Check if i is a divisor
            if (n % i == 0) {
                // Print the divisor i
                System.out.println(i);
            }
        }

        // Iterate through numbers i in reverse order from sqrt(n) to 1
        // These are the divisors larger than the square root
        for (; i >= 1; i--) {
            // Check if i is a divisor
            if (n % i == 0) {
                // Print the divisor n/i
                System.out.println(n / i);
            }
        }
    }

    public static void main(String[] args) {
        printDivisors(15);
    }
}
