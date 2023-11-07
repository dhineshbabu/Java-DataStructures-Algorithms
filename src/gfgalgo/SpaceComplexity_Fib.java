package gfgalgo;

public class SpaceComplexity_Fib {
    // space complexity: O(1)
    public static int fibonacci(int n) {
        if(n==0 || n==1) return n;
        int a =0, b=1;
        int c=0;

        for(int i=2; i<=n;i++) {
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
}
