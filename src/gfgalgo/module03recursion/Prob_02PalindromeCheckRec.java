package gfgalgo.module03recursion;

public class Prob_02PalindromeCheckRec {
    public static boolean isPalindrome(String s, int start, int end) {
        // Base case: if start is greater than or equal to end, it's a palindrome

        if (start >= end) return true;

        // Recursive case:
        // Check if the characters at positions start and end are equal,
        // and recursively check the substring between start+1 and end-1.

        return
                (s.charAt(start) == s.charAt(end)) &&
                        isPalindrome(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("kanak", 0, 4));
        System.out.println(isPalindrome("perf", 0, 3));
    }
}
