package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_StockSpan {
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
        // push the initial element index to the stack
        // stack will store only the index
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        System.out.print(1 + " ");

        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            System.out.print(span+" ");
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {60, 10, 20, 15, 35, 50};
        printSpan(arr);
    }

}


