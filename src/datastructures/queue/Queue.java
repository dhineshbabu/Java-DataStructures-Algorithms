package datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue() {
        this.length = 0;
    }

    public void getFirst() {
        if(this.length == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("First value is: " + this.first.value);
    }

    public void getLast() {
        if(this.length == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Last value is: " + this.last.value);
    }

    public void getLength() {
        System.out.println("Length of the queue is : " + this.length);
    }

    public void printQueue() {
        Node temp = this.first;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // enqueue method
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;

    }

    public Node dequeue() {
        if(this.length == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = this.first;
        if(this.length == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }
        this.length--;
        return temp;
    }
}
