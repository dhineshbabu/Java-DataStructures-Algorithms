package gfgalgo.arrays;

public class Prob_SumOfSubArraysKWindow {

    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7};

        // subarray window
        int k = 4;
        int curr = 0;

        // calculate the first k element sum
        for(int i=0; i<k; i++) {
            curr = curr+arr[i];
        }
        int res = curr;

        // calculate from the next sub array window (i.e) k-1
        for(int i=k; i<arr.length; i++) {
            curr = curr+arr[i]-arr[i-k];
            res = Math.max(curr, res);
        }

        System.out.println(res);
    }

}
