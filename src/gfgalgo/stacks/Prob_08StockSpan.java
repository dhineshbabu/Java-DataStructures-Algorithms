package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_08StockSpan {
    /*
    Naive Solution

     public static void printSpan(int arr[],int n){
        for(int i=0;i<n;i++){
            int span=1;
            for(int j=i-1;j>=0 && arr[j]<=arr[i];j--)
                span++;
            System.out.print(span+" ");
        }
    }
    public static void main (String[] args) {

        int[] arr=new int[]{18,12,13,14,11,16};

        printSpan(arr,arr.length);

    }

     */

    /*
    Efficient Solution 01

    idea is

    1. id there is a greater element on the left side
    span = (Index of current element) - (Index of closest greater element of the left side)

    else
    span = (Index of current element) + 1
     */

    static void printSpan(int[] arr) {
        int n = arr.length;

        // Create a stack to store indices of elements
        Deque<Integer> stack = new ArrayDeque<>();

        // Push the index of the first element to the stack
        stack.push(0);

        // The span of the first element is always 1
        System.out.print(1 + " ");

        // Traverse the array from the second element
        for (int i = 1; i < n; i++) {
            // Pop elements from the stack while the current element is greater than the element at the top of the stack
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // Calculate the span: If the stack is empty, the span is the current index + 1, else it's the difference between the current index and the index at the top of the stack
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();

            // Print the span for the current element
            System.out.print(span + " ");

            // Push the current index to the stack
            stack.push(i);
        }
    }


    public static void main(String[] args) {
        int[] arr = {60, 10, 20, 15, 35, 50};
        printSpan(arr);
    }

}


