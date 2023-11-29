package gfgalgo.queue;

import java.util.*;

public class Prob_06ReversingQueueItRec {
    /*
    there are 2 methods
    1. iterative
        create a stack
        push the elements from queue to stack
        again push the elements from stack to queue
    2. recursive
     */

    // Iterative Method
    static void reverse(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();

        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    // Recursive
    static void reverseRecursive(Queue<Integer> queue) {

        // base case
        if(queue.isEmpty()) return;

        int x = queue.remove();
        reverseRecursive(queue);
        queue.offer(x);

    }


    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(10);
        q1.offer(20);
        q1.offer(30);
        q1.offer(40);

        System.out.println(q1);
        reverse(q1);
        System.out.println(q1);
        reverseRecursive(q1);
        System.out.println(q1);

    }
}
