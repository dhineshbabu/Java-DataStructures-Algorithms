package gfgalgo.module13deque;

public class Prob_01DequeUsingArrays {
    /*
     * insertFront()
     * insertRear()
     * deleteFront()
     * deleteRear
     * getFront()
     * getRear()
     * isFull()
     * isEmpty()
     * size()
     */

    private int size;
    private int capacity;
    private int[] arr;
    private int front, rear;

    Prob_01DequeUsingArrays(int cap) {
        capacity = cap;
        size = 0;
        arr = new int[cap];
        front = 0;
        rear = 0;
    }

    void insertFront(int x) {
        if (isFull()) return;
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i]; // moving one element to the right
        }
        arr[0] = x;
        size++;
    }

    void insertRear(int x) {
        if (isFull()) return;

        arr[size++] = x;
    }


    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) ||
                (front == rear + 1));
    }

    int getFront() {
        if (isEmpty()) return -1;
        else return front;
    }

    int getRear() {
        if (isEmpty()) return -1;
        else return (front + size - 1) % capacity;
    }

    void deleteFront() {
        if (isEmpty()) return;
        front = (front + 1) % capacity;
        size--;
    }

    void deleteRear() {
        if (isEmpty()) return;
        size--;
    }

}
