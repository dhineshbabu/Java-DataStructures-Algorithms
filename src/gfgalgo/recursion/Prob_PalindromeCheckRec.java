package gfgalgo.recursion;

public class Prob_PalindromeCheckRec {
    public static boolean isPalindrome(String s, int start, int end) {
        // base case
        if(start >= end) return true;

        return
                (s.charAt(start) == s.charAt(end)) &&
                        isPalindrome(s, start+1, end-1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("kanak", 0, 4));
        System.out.println(isPalindrome("perf", 0, 3));
    }
}
