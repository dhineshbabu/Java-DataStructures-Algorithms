package gfgalgo.module19backtracking;

public class Prob_01PrintAllPermutationsBackTrc {

    public static char[] swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

    public static void permute(String str, int l, int r) {
        // Check if we have reached the end of the string, and if so, print the permutation
        if (l == r) {
            System.out.print(str + " ");
            return;
        } else {
            // Iterate through the characters from 'l' to 'r' to generate permutations
            for (int i = l; i <= r; i++) {
                // Check if swapping the characters at positions 'i' and 'l' is safe
                if (isSafe(str, l, i, r)) {
                    // Swap the characters at positions 'i' and 'l'
                    str = new String(swap(str, i, l));

                    // Recursively permute the remaining characters
                    permute(str, l + 1, r);

                    // Backtrack: Undo the previous swap to explore other possibilities
                    str = new String(swap(str, i, l));
                }
            }
        }
    }


    public static boolean isSafe(String str, int l, int i, int r) {
        // Check if placing 'B' at position 'i' is safe with respect to the character at position 'l-1'
        if (l != 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B') {
            // If the character at position 'l-1' is 'A' and the character at position 'i' is 'B', it's not safe.
            return false;
        }

        // Check if placing 'A' at position 'i' is safe with respect to the character at position 'l'
        if (r == (l + 1) && str.charAt(i) == 'A' && str.charAt(l) == 'B') {
            // If the characters at positions 'l' and 'i' are 'B' and 'A' respectively, and there's only one character between them,
            // placing 'A' at position 'i' is not safe.
            return false;
        }

        // If both checks pass, it's safe to place the character at position 'i'.
        return true;
    }


    public static void main(String args[]) {
        String str = "ABC";

        permute(str, 0, str.length() - 1);
    }
}
