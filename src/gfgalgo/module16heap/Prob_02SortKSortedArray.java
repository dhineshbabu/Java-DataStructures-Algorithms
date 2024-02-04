package gfgalgo.module16heap;

import java.util.*;

public class Prob_02SortKSortedArray {

    // Method to sort the array in k-sorted fashion using a min-heap
    private static void sortK(int[] arr, int n, int k) {

        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert the first k+1 elements into the min-heap
        for (int i = 0; i < k + 1; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        // Process the remaining elements in the array
        for (int i = k + 1; i < n; i++) {
            // Replace the current element in the array with the smallest element from the min-heap
            arr[index++] = pq.peek();
            pq.poll(); // Remove the smallest element from the min-heap
            pq.add(arr[i]); // Add the next element from the array to the min-heap
        }

        // Process any remaining elements in the min-heap and place them in the array
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }


    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2, 6, 3, 12, 56, 8};
        int n = arr.length;
        sortK(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
