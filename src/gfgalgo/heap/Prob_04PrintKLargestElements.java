package gfgalgo.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Prob_04PrintKLargestElements {
    /*
     calculating the K Largest Elements in an unsorted array
     */

    public static void firstKElements(int arr[], int n, int k) {

        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert the first k elements into the min-heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Process the remaining elements in the array
        for (int i = k; i < n; i++) {
            // Compare the smallest element in the min-heap with the current array element
            if (minHeap.peek() > arr[i])
                continue; // If the min-heap's smallest element is greater, skip to the next iteration
            else {
                minHeap.poll(); // Remove the smallest element from the min-heap
                minHeap.add(arr[i]); // Add the current array element to the min-heap
            }
        }

        // Use an iterator to print the elements of the min-heap
        Iterator<Integer> iterator = minHeap.iterator();

        // Print the elements of the min-heap
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
