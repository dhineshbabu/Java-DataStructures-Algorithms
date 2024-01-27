package gfgalgo.module02bitmagic;

public class Prob_02CountSetBits {

    // Brian Kerningam's Algorithm
    public static int countSetBits(int number) {
        int res = 0;
        // multiply n*n-1 until the number becomes 0 - This is the easiest way
        while (number > 0) {
            number = number & (number - 1);
            res = res + 1;
        }

        return res;
    }

    // using tabular method with Kerningam's algorithm
    public static int countSetBitsUsingTable(int number) {
        //initialize the table
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = table[i & (i - 1)] + 1;
        }

        // shift 8 bits to the right in each iteration and add
        return table[number & 255] + table[(number >> 8) & 255]
                + table[(number >> 16) & 25] + table[(number >> 24)];

    }

    public static void main(String[] args) {
        System.out.println(countSetBits(7));
        System.out.println(countSetBitsUsingTable(7));
    }
}
