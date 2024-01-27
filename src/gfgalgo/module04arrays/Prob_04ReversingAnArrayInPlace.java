package gfgalgo.module04arrays;

import java.util.Arrays;

public class Prob_04ReversingAnArrayInPlace {
    public static void main(String[] args) {
        // Given array
        int[] arr = {1, 3, 4, 5, 5, 6, 60};

        // Initialize pointers at the beginning and end of the array
        int low = 0;
        int high = arr.length - 1;

        // Reverse the array using the two-pointer technique
        while (low < high) {
            // Swap elements at the low and high positions
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;

            // Move the pointers towards the center
            low++;
            high--;
        }

        // Print the reversed array
        System.out.println(Arrays.toString(arr));
    }
}
