package gfgalgo.module11stacks;

import java.util.ArrayDeque;

public class Prob_05StackWithArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
