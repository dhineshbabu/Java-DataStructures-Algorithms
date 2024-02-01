package gfgalgo.module09strings;

public class Prob_LexiographicRankString {
    /*
    Lexiographic rank is
    sort the string
    calculate the permutations and order
    get the index of the input string from the list

    For long strings we will have factorial count, so we need an efficient solution

    Efficient Solution:
    formula = (count all lexiographically smaller string) + 1
     */

    static final int CHAR = 256;

    static int lexRank(String str) {
        // result variable will hold the final character
        int res = 1;
        int n = str.length();

        // calculate the intiial factorial
        int mul = fact(n);

        int[] count = new int[CHAR];

        //increment count array based on str characters
        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }

        // calculate the prefix sum array
        for (int i = 1; i < CHAR; i++) {
            count[i] += count[i - 1];
        }

        // main calculation to identify the lexiographically lesser characters and add it to the result for each level
        for (int i = 0; i < n - 1; i++) {
            mul = mul / (n - i); // each level the factorial will be reduced based on available characters

            // take the previous character count from prefix sum array and multiply with current factorial
            res = res + count[str.charAt(i) - 1] * mul;

            // reduce the count right side
            for (int j = str.charAt(i); j < CHAR; j++) {
                count[j]--;
            }
        }

        return res;
    }

    static int fact(int n) {
        if (n == 1) return 1;

        return n * fact(n - 1);
    }

    public static void main(String args[]) {
        String str = "STRING";
        System.out.print(lexRank(str));
    }
}
