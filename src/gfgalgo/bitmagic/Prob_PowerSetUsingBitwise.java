package gfgalgo.bitmagic;

public class Prob_PowerSetUsingBitwise {
    public  static void powerSet(String s) {
        int n = s.length();

        // Calculate the size of the power set, which is 2^n - e.g for 4 it will be 16 combinations
        int pSize = (1 << n);

        // Loop through all possible combinations using binary representation
        for (int i = 0; i < pSize; i++) {
            // Inner loop to iterate through each bit of the current combination
            for (int j = 0; j < n; j++) {
                // Check if the jth bit is set in the current combination (i)
                if ((i & (1 << j)) != 0)
                    System.out.print(s.charAt(j)); // Print the corresponding character from the input string
            }
            System.out.println(); // Move to the next line for the next subset
        }
    }

    public static void main(String[] args) {
        powerSet("kani");
    }

}
