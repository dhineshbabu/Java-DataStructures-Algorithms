package datastructures.backtracking;

public class Prob_PrintAllPermutations {
    /*
    print all the permutations that will not have "AB" in it
     */

    public static void permute(String str, int l, int r){
        // base case = if the current string is 3 chars long
        if(l==r) {
            // check if it contains string "AB" else print
            if(str.contains("AB") == false) {
                System.out.print(str + " ");
            }
        } else{

            for (int i = l; i <=r; i++) {
                str = new String(swap(str, i, l));
                permute(str, l+1, r);
                // moving to the same position
                str = new String( swap(str, i, l));
            }

        }
    }

    public static char[] swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

    public static void main(String args[])
    {
        String str="ABC";

        permute(str,0,str.length()-1);
    }

}
