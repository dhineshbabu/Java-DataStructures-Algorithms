package gfgalgo.module09strings;

public class Prob_06ReverseWordsInString {

    /*
    Note this is not the actual string but the actual words in reverse

    method
    start and end = 0
    use a reverse helper method
    if there is a space call the reverse helper
    after all the calls explicitly call the reverse helper for final word and then for the whole string
     */

    static void reverse(char str[], int low, int high) {
        while (low <= high) {
            //swap
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            //
            low++;
            high--;
        }
    }

    static void reverseWords(char str[], int n) {
        // step 1: reverse the individual words (identify them with space character)
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }

        // step 2: reverse the last word
        reverse(str, start, n - 1);

        // step 3: reverse the entire string from start to end
        reverse(str, 0, n - 1);
    }

    public static void main(String args[]) {
        String s = "Welcome to Gfg";
        int n = s.length();
        char[] str = s.toCharArray();
        System.out.println("After reversing words in the string:");
        reverseWords(str, n);
        System.out.println(str);
    }
}
