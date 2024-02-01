package gfgalgo.module09strings;

public class Prob_CheckForRotation {
    /*
    rotate any time counter clock wise and check if they are matching

    // simple way is to concatenate the first string twice and find the index of s2 in s1
     */

    static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return ((s1 + s1).indexOf(s2) >= 0);
    }


    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";

        System.out.println(areRotations(s1, s2));
    }

}
