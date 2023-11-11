package gfgalgo.sorting;

import java.util.Arrays;

public class Prob_ChocoloateDistribution {

    static int fairvalue(int[] arr, int k){
        int n= arr.length;

        if(k >n) return -1;

        Arrays.sort(arr);

        // get the first different
        int result = arr[k-1] - arr[0];

        for(int i=1; i+k-1<n; i++) {
            result = Math.min(result, arr[i+k-1]-arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fairvalue(new int[] { 7,3,2,4,9,12,56}, 3));
    }
}
