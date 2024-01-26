package gfgalgo.module01mathematics;

public class Prob_06TrailingZerosInFactorial {
    // Method to calculate the number of trailing zeros in the factorial of n
    public static int trailingZero(int n) {
        int count = 0;

        // Loop to count the number of multiples of 5 in the factorial
        for (int i = 5; i <= n; i = i * 5) {
            // Counting the number of 5's in the factorial
            count = count + (n / 5);
        }

        // Return the total count of trailing zeros
        return count;
    }

    public static void main(String[] args) {
        // Example usage with n = 5
        System.out.println(trailingZero(5));
    }
}

