package gfgalgo.module09strings;

public class Prob_01PrintFreqOfCharsInString {
    /*
    Maintain a count[] array to store the ascii positions as indes
    count[str.charAt(i)-'a']++ if the character is encountered
    while printing change it to (char)(i+'a')
     */
    public static void main(String[] args) {
        String str = "helloo";
        //count array
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        //print the frequency
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + " " + count[i]);
            }
        }
    }
}
