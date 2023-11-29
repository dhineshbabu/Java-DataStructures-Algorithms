package gfgalgo.queue;

public class Prob_03QueueUsingLinkedList {
    /*
    when we use single linked list for queue implementation
    always use head as front for removing an element
    rear as tail for adding an element
     */

    static class Node{
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Queue class
    Node front, rear;

    // constructor
    Prob_03QueueUsingLinkedList() {
        front = null;
        rear = null;
    }

    // always at the rear end
    void enqueue(int n) {
        Node temp = new Node(n);
        if(front == null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    void dequeue() {
        if(front == null) return;
        Node temp = front;
        front = front.next;
        if(front == null) rear = null;
        System.out.println(temp.data);
    }
}
