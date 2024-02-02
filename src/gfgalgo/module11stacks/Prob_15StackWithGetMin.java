package gfgalgo.module11stacks;

import java.util.Stack;

    /*
    Stack with additional operation getMin()
    idea is to maintain an auxiliary stack
        while pushing check if the current element is less than the top of aux stack then push it
        while popping check if the popped is the top of the aux stack then remove from aux stack

        // below solution is works with space: O(1)
        idea is to store element-currMin in a variable if there is another minimum value
        this works for the stack only with positive value
         - so if there is a -ve element on the stack then while removing do the curr min - (-ve) element to get the output

         // for stacks even with negative values
          if the current element is less than curr minimum then push (2*x-currmin)
          while popping, if(top is < currMin) then return min instead of top then udpate the minimum as 2*min-top
     */

public class Prob_15StackWithGetMin {

    // Stack to store elements
    Stack<Integer> s;

    // Variable to store the minimum element
    int min;

    // Constructor to initialize the stack
    Prob_15StackWithGetMin() {
        s = new Stack<>();
    }

    // Method to push an element onto the stack
    void push(int x) {
        // If the stack is empty, set the minimum to the new element
        if (s.isEmpty()) {
            min = x;
            s.add(x);
        }
        // If the new element is less than or equal to the current minimum, adjust the value pushed onto the stack
        else if (x <= min) {
            s.add(2 * x - min);
            min = x;
        }
        // If the new element is greater than the current minimum, push it as is
        else {
            s.add(x);
        }
    }

    // Method to pop an element from the stack
    int pop() {
        // Pop the top element from the stack
        int t = s.peek();
        s.pop();
        // If the popped element is less than or equal to the minimum, adjust the minimum
        if (t <= min) {
            int res = min;
            min = 2 * min - t;
            return res;
        }
        // If the popped element is greater than the minimum, return it as is
        else {
            return t;
        }
    }

    // Method to peek at the top element of the stack
    int peek() {
        int t = s.peek();
        // Return the minimum if the top element is less than or equal to the minimum, otherwise return the top element
        return ((t <= min) ? min : t);
    }

    // Method to get the minimum element in the stack
    int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Prob_15StackWithGetMin s = new Prob_15StackWithGetMin();
        ;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin());

    }
}
