package gfgalgo.module16heap;

public class Prob_01MinHeap {

    int arr[];      // Array to store the heap elements
    int size;       // Current size of the heap
    int capacity;   // Maximum capacity of the heap

    // Constructor to initialize the heap with a given capacity
    Prob_01MinHeap(int c) {
        size = 0;               // Initial size is 0
        capacity = c;           // Set the capacity
        arr = new int[c];        // Initialize the array to store the heap elements
    }

    // Helper functions to calculate indices
    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    // Method to insert a new element into the min heap
    public void insert(int x) {
        // Check if the heap is already at full capacity
        if (size == capacity) return;

        // Increment the size and add the new element at the end of the array
        size++;
        arr[size - 1] = x;

        // Heapify Up: Reorganize the heap to maintain the min heap property
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
            // Swap the current element with its parent if the parent is greater
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            // Move to the parent index for further comparison
            i = parent(i);
        }
    }

    public void minHeapify(int i) {
        // Calculate the indices of the left and right children of node i
        int lt = left(i);
        int rt = right(i);

        // Assume the current node i is the smallest
        int smallest = i;

        // Compare the value at the left child with the value at the current node
        if (lt < size && arr[lt] < arr[i])
            smallest = lt;

        // Compare the value at the right child with the value at the smallest so far
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;

        // If the current node is not the smallest, swap its value with the smallest
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively call minHeapify on the affected subtree
            minHeapify(smallest);
        }
    }

    public int extractMin() {
        // Check if the heap is empty
        if (size <= 0)
            return Integer.MAX_VALUE;

        // If there is only one element in the heap
        if (size == 1) {
            size--;
            return arr[0];
        }

        // Swap the root (minimum element) with the last element
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        // Decrease the size of the heap
        size--;

        // Restore the min-heap property by calling minHeapify on the root
        minHeapify(0);

        // Return the extracted minimum element
        return arr[size];
    }

    public void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--)
            minHeapify(i);
    }

    void decreaseKey(int i, int x) {
        // Update the value at index i with the new value x
        arr[i] = x;

        // Continue the loop as long as i is not the root and the parent's value is greater than the current value
        while (i != 0 && arr[parent(i)] > arr[i]) {
            // Swap the current value with its parent
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            // Move up the tree to the parent
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String args[]) {
        Prob_01MinHeap h = new Prob_01MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
    }

}
