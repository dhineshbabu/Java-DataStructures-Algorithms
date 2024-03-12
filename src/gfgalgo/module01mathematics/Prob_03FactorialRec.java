package gfgalgo.module01mathematics;

public class Prob_03FactorialRec {
    public static long fact(long n) {
        if (n < 1) return 1;

        else return n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(10));
        System.out.println(fact(15));
        System.out.println(fact(25));
    }
}

