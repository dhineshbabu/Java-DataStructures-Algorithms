package gfgalgo.recursion;

public class Prob_05GenerateUniqueSubSequences {

    /*
    for a string of length n, there will be 2^n subsequences
     */

    public static void subsets (String s, String currentChar, int counter) {
        // define the base case
        if(counter == s.length()) {
            System.out.println(currentChar);
            return;
        }

        // first recursive combination without new char from string array
        subsets(s, currentChar, counter+1);

        // second recursive combination with new char from string array
        subsets(s, currentChar+s.charAt(counter), counter+1);
    }

    public static void main(String[] args) {
        subsets("ABC", "", 0);
    }
}
