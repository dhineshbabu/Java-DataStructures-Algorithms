package gfgalgo.recursion;

public class Prob_JosephusProblem {
    public static int survivor(int n, int k) {
        if(n ==1) return 0;
        else
            return (survivor(n-1, k) + k) %n;
    }
}
