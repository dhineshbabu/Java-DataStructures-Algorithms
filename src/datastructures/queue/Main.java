package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.enqueue(10);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        System.out.println(queue.dequeue().value);
        queue.printQueue();
    }
}
