package gfgalgo.queue;
import java.util.*;

public class Prob_04QueueWithArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());
    }
}
