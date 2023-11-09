package gfgalgo.arrays;

public class Prob_PrefixSum {
    /*
    This can be accomplished using pre-computed sum in an array
    so
    getSum(l, r)
        if l=0,  pSum[r]
        else psum[r] - psum[l-1]
     */

    static int prefixSum(int[] ps, int l, int r) {
        if(l == 0) return ps[r];

        return ps[r] - ps[l-1];
    }

    public static void main(String[] args) {
        int arr[]={2, 8, 3, 9, 6, 5, 4};
        int n = arr.length;

        int[] ps = new int[n];

        ps[0] = arr[0];

        // calculate the prefix array
        for (int i=1; i<n; i++) {
            ps[i] = ps[i-1]+arr[i];
        }

        System.out.println(prefixSum(ps, 1,3));
    }
}
