package gfgalgo.recursion;

public class Prob_10PrintingBinaryOfInt {
    public static void binary(int n) {
        // base case
//        System.out.println(n);
        if(n==0) return;

        // recursion
        binary(n/2);

        // print during unwinding
        System.out.print(n%2);
    }

    public static void main(String[] args) {
        binary(8);
    }
}
