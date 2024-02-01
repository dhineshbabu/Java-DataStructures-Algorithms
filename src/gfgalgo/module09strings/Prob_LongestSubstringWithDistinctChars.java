package gfgalgo.module09strings;

import java.util.Arrays;

public class Prob_LongestSubstringWithDistinctChars {
    /*
    Compute the maxend(j) - longest substring ends at j
    then use the 4 steps process to find the unique string

    Maintain a "prev" array with -1

     */

    static int longestDistinct(String str) {
        int n = str.length(), res = 0;

        int[] prev = new int[256];

        Arrays.fill(prev, -1);

        int i = 0;

        // loop through the string
        for (int j = 0; j < n; j++) {
            // calculate the previous position if the character is occurred again
            i = Math.max(i, prev[str.charAt(j)] + 1); // to calculate the unique length doe speciic char
            int maxEnd = j - i + 1; // current- previous position of this character

            res = Math.max(res, maxEnd);

            // set the previous of the current character to this position for subsequqnt irterations
            prev[str.charAt(j)] = j;
        }

        return res;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        int len = longestDistinct(str);
        System.out.print("The length of the longest distinct characters substring is " + len);
    }
}
