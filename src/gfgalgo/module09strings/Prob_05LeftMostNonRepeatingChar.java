package gfgalgo.module09strings;


public class Prob_05LeftMostNonRepeatingChar {
    /*
    same as leftmost repeating character
    with modified sections
     */


    static final int CHAR = 256;

    static int leftMost(String str) {

        // Boolean array to keep track of visited characters
        boolean[] visited = new boolean[CHAR];

        // Variable to store the result (leftmost non-repeating character)
        char res = ' ';

        // Traverse the string from right to left
        for (int i = str.length() - 1; i >= 0; i--) {
            // If the character is already visited or equal to the result
            if (visited[str.charAt(i)] || str.charAt(i) == res) {
                // If the character is equal to the result, reset the result
                if (str.charAt(i) == res) res = ' ';
                // Continue to the next iteration
                continue;
            } else {
                // Mark the character as visited
                visited[str.charAt(i)] = true;
                // Update the result with the current character
                res = str.charAt(i);
            }
        }

        // Return the index of the leftmost non-repeating character in the original string
        return str.indexOf(res);
    }

    public static void main(String[] args) {
        String str = "cabba"; // index of a should be the answer
        System.out.println(leftMost(str));
    }
}
