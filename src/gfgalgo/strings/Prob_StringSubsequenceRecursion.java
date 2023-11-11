package gfgalgo.strings;

public class Prob_StringSubsequenceRecursion {
    static boolean subSequenceRec(String s1, String s2, int len1, int len2){
        // calculate the length
        int n1 = len1;
        int n2 = len2;

        // base cases
        if(n2 == 0) {
            // we found the subsequqnce
            return true;
        }

        if(n1 == 0) {
            // source string ended we did not find the subsequence
            return false;
        }

        // for each recurive call if char matches then recude both n1 and n2
        if (s1.charAt(n1 - 1) == s2.charAt(n2- 1)) {
            return subSequenceRec(s1, s2, n1-1, n2-1);
        } else {
            // just reduce the n1 count
            return subSequenceRec(s1,s2, n1-1, n2);
        }
    }

    public static void main(String[] args) {
        String s1 = "helloo";
        String s2 = "llo";
        System.out.println(subSequenceRec(s1, s2, s1.length(), s2.length()));

    }
}
