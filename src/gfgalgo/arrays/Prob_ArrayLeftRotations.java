package gfgalgo.arrays;

import java.util.Arrays;

public class Prob_ArrayLeftRotations {
    public static void leftRotateOne(int[] arr) {
        int temp = arr[0];
        int n = arr.length;
        for(int i=1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }

    // rotating n digits with reverse helper method
    public static void leftRotateKDigits(int[] arr, int k) {
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    static void reverse(int arr[], int low, int high) {
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        leftRotateOne(nums);
        System.out.println(Arrays.toString(nums));

        leftRotateKDigits(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
