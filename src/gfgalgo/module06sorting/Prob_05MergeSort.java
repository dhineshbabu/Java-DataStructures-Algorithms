package gfgalgo.module06sorting;

public class Prob_05MergeSort {
    /*
    Divide and Conquer and Merge
    Stable Sort
    O(nlogn)
    Well suited for Linked list

    1. check if at-least 2 elements in the array
    2. find the mid-point and recursively apply the mergesort for both the left and right half
    3. then merge the arrays

     */

    // Function to merge two subarrays of 'arr' array
    // First subarray is arr[l..mid]
    // Second subarray is arr[mid+1..r]
    static void merge(int[] arr, int l, int mid, int r) {
        int m = mid - l + 1; // Size of the first subarray
        int n = r - mid; // Size of the second subarray

        // Create temporary arrays to hold the data of the two subarrays
        int[] left = new int[m];
        int[] right = new int[n];

        // Fill the temporary arrays with data from the main array
        for (int i = 0; i < m; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = l; // Initialize indices for merging

        // Merge the two subarrays back into the main array in sorted order
        while (i < m && j < n) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        // If there are remaining elements in the 'left' array, copy them to the main array
        while (i < m)
            arr[k++] = left[i++];

        // If there are remaining elements in the 'right' array, copy them to the main array
        while (j < n)
            arr[k++] = right[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        // split the array until l>r that is minimum 1 element
        if (l < r) {
            int mid = l + (r - l) / 2;
            // call the merge sort for the left half
            mergeSort(arr, l, mid);
            // call the merge sort for the right half
            mergeSort(arr, mid + 1, r);
            //merge the arrays as sorted after splitting
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{10, 5, 30, 15, 7};
        int l = 0, r = 4;

        mergeSort(a, l, r);
        for (int x : a)
            System.out.print(x + " ");

    }

}
