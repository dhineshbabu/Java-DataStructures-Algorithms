package gfgalgo.module09strings;

public class Prob_02PalindromeCheck {
    /*
    Use 2 pointers and compare the left and right elements
    if they are not equal then false

    Naive method:
        use string builder and reverse an compare
     */

    static boolean isPalindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;
        while (begin <= end) {
            if (str.charAt(begin) == str.charAt(end)) {
                return true;
            }
            begin++;
            end--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("malayalam"));
    }
}
