package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_11LargestRectAreaInHistogram {
    /*
    Need to perform the opposite of previous smaller and next smaller
     */

    static int getMaxArea(int[] arr){
        int n = arr.length;

        // initiate stack
        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;

        // loop through the array ad process the max item

        for (int i = 0; i <n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                // then pop the item and process
                int top = stack.pop();
                // calculate the current max
                int curr = arr[top] * (stack.isEmpty() ? i : (i-stack.peek() -1));
                result = Math.max(curr, result);
            }
            // push the current index to the stack
            stack.push(i);
        }

        // process the rest of the elements available in stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? n : (n-stack.peek()  -1));
            result = Math.max(curr, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea(arr));
    }
}
