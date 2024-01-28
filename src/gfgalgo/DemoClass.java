package gfgalgo;

import java.util.Arrays;

public class DemoClass {
    public static int subset(int[] arr, int n, int sum) {
        // base case
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        return subset(arr, n - 1, sum) + subset(arr, n - 1, sum - arr[n - 1]);
    }

    public static int removeArrDuplicates(int[] arr) {
        int n = arr.length;
        int res = 1;


        for (int i = 1; i < arr.length; i++) {
            if (arr[res - 1] != arr[i]) {
                arr[res] = arr[i];
                res++;
            }
        }

        return res;
    }


    public static void main(String[] args) {


        int[] nums = {10, 20, 15, 5};
        int sum = 25;
        System.out.println(subset(nums, nums.length, sum));

        int[] arr = {10, 20, 20, 30, 30, 30};
        System.out.println(removeArrDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
