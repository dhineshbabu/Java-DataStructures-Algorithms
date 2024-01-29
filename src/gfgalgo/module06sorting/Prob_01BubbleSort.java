package gfgalgo.module06sorting;

import java.util.Arrays;

public class Prob_01BubbleSort {
    /*
    take each element and compare with adjacent element
    after 1st pass max element will go to the end

    use swapped variable to track the status

     */
    // Function to perform the bubble sort algorithm on an array
    public static void sort(int[] arr) {
        int n = arr.length;

        // Outer loop for multiple passes through the array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Flag to track whether any elements were swapped in this pass

            // Inner loop for comparing and swapping adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Set the 'swapped' flag to true
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, the array is already sorted
            // and we can break out of the loop early
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int a[] = {2, 1, 4, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
