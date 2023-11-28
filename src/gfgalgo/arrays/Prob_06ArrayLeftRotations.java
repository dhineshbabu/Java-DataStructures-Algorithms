package gfgalgo.arrays;

import java.util.Arrays;

public class Prob_06ArrayLeftRotations {


    // Function to left rotate the elements of an array by one position
    public static void leftRotateOne(int[] arr) {
        // Store the first element of the array in a temporary variable
        int temp = arr[0];

        // Get the length of the array
        int n = arr.length;

        // Shift each element to the left by one position
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end of the array
        arr[n - 1] = temp;
    }

    // rotating n digits with reverse helper method
    // Function to left rotate the first 'k' elements of an array
    public static void leftRotateKDigits(int[] arr, int k) {
        // Reverse the first 'k' elements of the array
        reverse(arr, 0, k - 1);

        // Reverse the remaining elements of the array (from index 'k' to the end)
        reverse(arr, k, arr.length - 1);

        // Reverse the entire array to complete the left rotation
        reverse(arr, 0, arr.length - 1);
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
