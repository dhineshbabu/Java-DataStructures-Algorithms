package gfgalgo.heap;

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
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }
    int parent(int i) { return (i - 1) / 2; }

    // Method to insert a new element into the min heap
    public void insert(int x) {
        // Check if the heap is already at full capacity
        if (size == capacity) return;

        // Increment the size and add the new element at the end of the array
        size++;
        arr[size - 1] = x;

        // Heapify Up: Reorganize the heap to maintain the min heap property
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            // Swap the current element with its parent if the parent is greater
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            // Move to the parent index for further comparison
            i = parent(i);
        }
    }

    public void minHeapify(int i)
    {
        int lt = left(i);
        int rt = right(i);
        int smallest = i;
        if (lt < size && arr[lt] < arr[i])
            smallest = lt;
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;
        if (smallest != i)
        {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public int extractMin()
    {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1)
        {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = temp;
        size--;
        minHeapify(0);

        return arr[size];
    }

    public void buildHeap(){
        for(int i=(size-2)/2;i>=0;i--)
            minHeapify(i);
    }

    void decreaseKey(int i, int x)
    {
        arr[i] = x;
        while (i != 0 && arr[parent(i)] > arr[i])
        {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public static void main(String args[])
    {
        Prob_01MinHeap h=new Prob_01MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
    }

}
