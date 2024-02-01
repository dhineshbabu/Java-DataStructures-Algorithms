package gfgalgo.module09strings;

public class Prob_04LeftMostRepeatingCharacter {
    /*
    Problem: Given a string, the task is to find the first character (whose leftmost appearance is first) that repeats.

    keep a boolean visited array with false as intial value
    traverse from the right of the array

    set res = -1

    go from the last
    if the character is visited then store the index to i
    else this is the first time then set the boolean array to tru for that
     */


    static final int CHAR = 256;

    static int leftMost(String str) {

        boolean[] visited = new boolean[CHAR];

        int res = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)]) {
                res = i; // at last res will hold the left most visited character index
            } else {
                visited[str.charAt(i)] = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "cabba"; // index of a should be the answer
        System.out.println(leftMost(str));
    }
}
