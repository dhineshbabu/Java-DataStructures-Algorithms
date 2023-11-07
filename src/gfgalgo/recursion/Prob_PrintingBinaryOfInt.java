package gfgalgo.recursion;

public class Prob_PrintingBinaryOfInt {
    public static void binary(int n) {
        // base case
        if(n==0) return;

        // recursion
        binary(n/2);

        // print during unwinding
        System.out.print(n%2);
    }

    public static void main(String[] args) {
        binary(7);
    }
}
