package gfgalgo.module09strings;

public class Prob_NaivePatternSearching {

    static void patternSearch(String input, String pattern) {
        int m = pattern.length();
        int n = input.length();

        for (int i = 0; i <= (n - m); i++) {
            // check for in equality
            int j;
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != input.charAt(i + j)) {
                    break;
                }
            }
            // if matches
            if (j == m) {
                System.out.println(i + " ");
            }
        }
    }

    static void patternSearchImproved(String input, String pattern) {
        int m = pattern.length();
        int n = input.length();

        for (int i = 0; i <= (n - m); ) {
            // check for in equality
            int j;
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != input.charAt(i + j)) {
                    break;
                }
            }
            // if matches
            if (j == m) {
                System.out.println(i + " ");
            }
            // improved code
            if (j == 0) i++;
            else {
                i = i + j; //move the chars to the j position as the string is of unique chars
                // so that we can safely skip j positions
            }
        }
    }


    public static void main(String args[]) {
        String txt = "ABCABCD";
        String pat = "ABCD";
        System.out.print("All index numbers where pattern found: ");
        patternSearch(txt, pat);

        System.out.println("******* improved *******");
        System.out.print("All index numbers where pattern found: ");
        patternSearchImproved(txt, pat);

    }
}
