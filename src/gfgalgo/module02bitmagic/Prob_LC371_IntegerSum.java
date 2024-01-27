package gfgalgo.module02bitmagic;

public class Prob_LC371_IntegerSum {
    public static int getSum(int a, int b) {
        /*
        Given two integers a and b, return the sum of the two integers without using the operators + and -.
         */
        // If one of the numbers is zero, return the other number
        if (a == 0) return b;
        if (b == 0) return a;

        // Perform addition using bitwise operations
        while (b != 0) {
            // Calculate the carry using bitwise AND
            int carry = a & b;

            // XOR a and b to get the sum
            a = a ^ b;

            // Left shift the carry by 1 position for the next iteration
            b = carry << 1;
        }

        // Return the final sum
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(9, 10));
    }


}
