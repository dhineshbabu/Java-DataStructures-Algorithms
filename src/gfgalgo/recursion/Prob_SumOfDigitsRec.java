package gfgalgo.recursion;

public class Prob_SumOfDigitsRec {
    public static int sum(int n) {
        if(n == 0) return 0;
        int digit = n%10;
        return digit + sum(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sum(253));
    }
}
