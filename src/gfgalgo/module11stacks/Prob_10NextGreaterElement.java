package gfgalgo.module11stacks;

import java.util.*;
import java.util.stream.Collectors;

public class Prob_10NextGreaterElement {
    /*
    similar to previous greater element problem, but in reverse

     */

    static void nextGreater(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        // push the last element
        stack.push(arr[n - 1]);
        System.out.print("-1 ");

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            int greaterElement = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(greaterElement + " ");
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
        nextGreater(arr);  // print the output in reverse order - push in on to array list and print in reverse
        
    }
}
