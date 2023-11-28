package gfgalgo.arrays;

public class Prob_19maxDifference {
    /*
    Given an array arr[] of integers, find out the maximum difference between any two elements such that the larger element appears after the smaller number.

     */

    public static int maxDiff(int[] arr) {
        int res = arr[1] - arr[0];
        int minVal = arr[0];
        int n = arr.length;

        for(int j=1; j<n; j++) {
            // calculate the max difference so far
            res = Math.max(res, arr[j]-minVal);
            // keep track of the minimum element in the array so far
            minVal = Math.min(minVal, arr[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 10, 6, 4, 8, 1}, n = 7;

        System.out.println(maxDiff(arr));
    }
}
