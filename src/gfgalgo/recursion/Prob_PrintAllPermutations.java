package gfgalgo.recursion;

public class Prob_PrintAllPermutations {
    /*
    for the string contains length n, the permutation is n!
     */
    public static void printPermutations (String s, int i) {
        if (i == s.length() - 1) {
            System.out.println(s + " ");
            return;
        }
        for(int j=i; j<s.length(); j++) {
            s = swap(s, i, j);
            printPermutations(s, i+1);
            s = swap(s, i, j );
        }

    }

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        printPermutations("ABC", 0);
    }
}
