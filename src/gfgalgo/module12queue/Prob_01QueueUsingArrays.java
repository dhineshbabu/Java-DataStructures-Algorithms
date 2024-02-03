package gfgalgo.module12queue;

public class Prob_01QueueUsingArrays {
    private int size;
    private int capacity;
    private int[] arr;

    // Constructor
    Prob_01QueueUsingArrays(int cap) {
        arr = new int[cap];
        capacity = cap;
        size = 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int getFront() {
        if (isEmpty()) return -1;
        else return 0; // front will always be 0, only rear will change
    }

    int getRear() {
        if (isEmpty()) return -1;
        else return size - 1; //becauwe index starts with 0
    }

    void enqueue(int x) {
        if (isFull()) return;

        arr[size] = x;
        size++;
    }

    void dequeue() {
        if (isEmpty()) return;
        else {
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i - 1];
            }
            size--;
        }
    }
}
