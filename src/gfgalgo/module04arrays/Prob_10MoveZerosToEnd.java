package gfgalgo.module04arrays;

import java.util.Arrays;

public class Prob_10MoveZerosToEnd {

    public static void main(String[] args) {
        // Example array containing both non-zero and zero elements
        int[] arr = {10, 0, 20, 3, 4, 0, 3, 4};

        // Variable to keep track of the position where non-zero elements should be placed
        int count = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is non-zero
            if (arr[i] != 0) {
                // Swap the current non-zero element with the element at the 'count' position
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                // Increment the 'count' variable to move to the next position for non-zero elements
                count++;
            }
        }

        // Print the array after moving all non-zero elements to the front
        System.out.println(Arrays.toString(arr));
    }

}
