package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_PreviousGreaterElement {
    /*
    idea is
    push the first element and print -1 as it will not ahve any larger element prior to that

    from the next element remove all the smaller element form the stack top
    if stack becomes empty the print -1 else print s.peek()
     */

    static void previousGreaterElement(int[] arr) {
        int n = arr.length;

        // push the first element and print -1
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        System.out.print("-1 " );

        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            int greaterElement = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(greaterElement+" ");
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 5, 15};
        previousGreaterElement(arr);
    }
}
