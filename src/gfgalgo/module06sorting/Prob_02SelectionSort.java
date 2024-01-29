package gfgalgo.module06sorting;

import java.util.Arrays;

public class Prob_02SelectionSort {
    /*
    Does less memory writes
    It is the basic idea for heap sort
    Not stable
    Inplace algorithm
    idea is to find minimum element and move it to first, find 2nd minimum and move it to 2nd position, etc.

     */
    public static void sort(int[] arr) {
        int min_ind; // Variable to store the index of the minimum element in the unsorted part of the array

        // Outer loop for selecting the minimum element and moving it to the sorted part of the array
        for (int i = 0; i < arr.length - 1; i++) {
            min_ind = i; // Assume the current index is the minimum

            // Inner loop to find the minimum element in the unsorted part of the array
            // Note: The loop condition is 'j < arr.length - 1' instead of 'j < arr.length'
            // to prevent unnecessary comparison with the last element, which is already in its correct position
            for (int j = i + 1; j < arr.length; j++) {
                // If the element at the current index is less than the element at the assumed minimum index,
                // update the minimum index to the current index
                if (arr[min_ind] > arr[j]) {
                    min_ind = j;
                }
            }

            // Swap the minimum element (found in the inner loop) with the current position 'i'
            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 5, 8, 20, 2, 18};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
