package gfgalgo.bitmagic;

import java.util.Arrays;

public class Prob_LC338_CountBitsInArrayRange {
    /*


     The code uses dynamic programming to build the solution incrementally. The count of set bits for each number is computed based on the counts of set bits for smaller numbers.
     */

    public static int[] countBits(int num) {
        int[] output = new int[num + 1];

        // Iterate from 1 to num
        for (int i = 1; i < output.length; i++) {
            // Count the set bits by adding the count of set bits in i >> 1 and i % 2
            output[i] = output[i >> 1] + i % 2;
        }

        return output;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5))); //[0, 1, 1, 2, 1, 2]
    }

}
