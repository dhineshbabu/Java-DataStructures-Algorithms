package gfgalgo.recursion;

public class Prob_RopeCuttingProblem {

    /*
    given a rope length n, cut the rope into max number of pieces in such a way that
    each piece will have length a,b,c

    return -1 if it is not possible to cut the ropes
     */

    public static int maxRopeCuts(int n , int a, int b, int c) {
        // write down the base case
        if(n==0) return 0;
        if(n<=-1) return -1;

        //recursive part
        int res = Math.max(
                maxRopeCuts(n-a, a, b, c),
                Math.max(maxRopeCuts(n-b, a, b, c),
                maxRopeCuts(n-c, a, b, c))
        );
        if(res == -1) return -1; // no possibilities
        return res+1;
    }

    public static void main(String[] args) {
        int n = 5, a = 3, b = 3, c = 5;

        System.out.println(maxRopeCuts(n, a, b, c));
    }
}
