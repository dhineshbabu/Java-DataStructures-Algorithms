package gfgalgo.recursion;

public class Prob_04RopeCuttingProblem {

    /*
    given a rope length n, cut the rope into max number of pieces in such a way that
    each piece will have length a,b,c

    return -1 if it is not possible to cut the ropes
     */

    public static int maxRopeCuts(int n , int a, int b, int c) {
        // write down the base case

        // Base case: if n becomes 0, no more cuts can be made
        if(n==0) return 0;

        // Base case: if n becomes negative, no valid cuts can be made
        if(n<=-1) return -1;

        // Recursive part:
        // Calculate the maximum cuts by choosing one of the three lengths (a, b, or c) at each step
        int res = Math.max(
                maxRopeCuts(n-a, a, b, c),
                Math.max(maxRopeCuts(n-b, a, b, c),
                maxRopeCuts(n-c, a, b, c))
        );

        // If no valid cuts can be made, return -1
        if(res == -1) return -1; // no possibilities

        // Return the maximum cuts + 1 (current cut)
        return res+1;
    }

    public static void main(String[] args) {
        int n = 5, a = 3, b = 3, c = 5;

        System.out.println(maxRopeCuts(n, a, b, c));
    }
}
