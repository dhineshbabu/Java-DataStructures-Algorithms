package gfgalgo.deque;

public class DequeUsingArrays {
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

    DequeUsingArrays(int cap) {
        capacity = cap;
        size = 0;
        arr = new int[cap];
        front = -1;
        rear = 0;
    }

    boolean isEmpty(){
        return front == -1;
    }

    boolean isFull() {
        return ((front == 0 && rear == size-1) ||
                (front == rear+1));
    }

    int getFront() {
        if(isEmpty()) return -1;
        else return front;
    }

    int getRear() {
        if(isEmpty()) return -1;
        else return (front+size -1) % capacity;
    }

    void deleteFront(){
        if(isEmpty()) return;
        front = (front+1)%capacity;
        size--;
    }

    void deleteRear() {
        if(isEmpty()) return;
        size--;
    }

}
