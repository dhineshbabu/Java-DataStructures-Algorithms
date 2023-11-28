package gfgalgo.recursion;

public class Prob_03SumOfDigitsRec {
    public static int sum(int n) {
        // base case
        if(n == 0) return 0;

        // get the last digit from the number
        int digit = n%10;

        // recursive call
        return digit + sum(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sum(253));
    }
}
