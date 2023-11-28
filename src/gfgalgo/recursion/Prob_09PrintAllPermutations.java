package gfgalgo.recursion;

public class Prob_09PrintAllPermutations {
    /*
    for the string contains length n, the permutation is n!
     */
    public static void printPermutations (String s, int i) {
        // Base case: If we reach the end of the string, print the current permutation and return

        if (i == s.length() - 1) {
            System.out.println(s + " ");
            return;
        }
        // Recursive case:
        // Iterate through each character from index i to the end of the string

        for(int j=i; j<s.length(); j++) {
            // Swap the characters at indices i and j to generate a new permutation
            s = swap(s, i, j);

            // Recursively call printPermutations with the updated string and the next index i+1
            printPermutations(s, i+1);

            // Undo the swap to backtrack and explore other permutations
            s = swap(s, i, j );
        }

    }

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        printPermutations("ABCD", 0);
    }
}
