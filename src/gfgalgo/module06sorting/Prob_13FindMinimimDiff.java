package gfgalgo.module06sorting;

import java.util.Arrays;

public class Prob_13FindMinimimDiff {
    /*
    idea is sort the array
    compute the different between adjacent elements
     */
    static int getDiff(int[] arr) {
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            result = Math.min(result, arr[i] - arr[i - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getDiff(new int[]{10, 8, 1, 4}));
    }
}
