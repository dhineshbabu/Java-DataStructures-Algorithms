package gfgalgo.module06sorting;

public class CountingSort {
    /*
    ø(n+k) Time Complexity
    Stable
    Used as a subroutine in Redix Sort
     */

    public static void main(String[] args) {
        int arr[] = {1, 4, 4, 1, 0, 1};
        int n = arr.length;
        int k = 5;
        countSort(arr, n, k);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

    }

    static void countSort(int arr[], int n, int k) {
        // create a new count array
        int[] count = new int[k];

        // fill the count array with 0's
        for (int i = 0; i < k; i++)
            count[i] = 0;

        // increase count array values according to the indexes in input array
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        // conver the count array to cumulative values by adding the previous items
        for (int i = 1; i < k; i++)
            count[i] = count[i - 1] + count[i];

        // create a new output array to store the result arary

        int[] output = new int[n];

        // build thje output array by placing the input array elements based on index from count array and recude the count in count array

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // copy the output to the actual array

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}
