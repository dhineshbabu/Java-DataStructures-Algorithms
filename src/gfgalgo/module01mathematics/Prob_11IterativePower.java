package gfgalgo.module01mathematics;

public class Prob_11IterativePower {
    /*
    idea is to use bitwise operations to multiple the given number
     */

    /**
     * Calculates the power of a number using the binary exponentiation algorithm.
     *
     * @param x the base
     * @param n the exponent
     * @return the result of x raised to the power of n
     */
    public static int power(int x, int n) {
        // Initialize the result to 1
        int res = 1;

        // Loop until the exponent becomes zero
        while (n > 0) {
            // Check if the current bit of the exponent is 1 (using bitwise AND with 1)
            if ((n & 1) == 1) {
                // Multiply the result by the base when the current bit is 1
                res = res * x;
            }

            // Square the base for the next iteration (equivalent to raising to the power of 2)
            x = x * x;

            // Right shift the exponent by 1 to consider the next bit in the next iteration
            n = n >> 1;
        }

        // Return the final result
        return res;
    }


    public static void main(String[] args) {
        System.out.println(power(5, 2));
    }
}
