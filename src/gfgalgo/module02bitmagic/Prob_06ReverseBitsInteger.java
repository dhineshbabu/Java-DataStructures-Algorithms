package gfgalgo.module02bitmagic;

public class Prob_06ReverseBitsInteger {

    public static int reverseBits(int n) {
        // Time complexity: O(1)
        int reverse = 0;

        // Loop through each bit (32 bits in a 32-bit integer)
        for (int i = 1; i <= 32; i++) {
            // Shift the current reversed bits to the left by 1 position
            reverse = reverse << 1;

            // Extract the rightmost bit from the original number and set it in the reversed number
            reverse = reverse | (1 & n);

            // Shift the original number to the right by 1 position
            n = n >> 1;
        }

        // Return the reversed integer
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(4));
    }
}
