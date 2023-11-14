package gfgalgo.stacks;

import java.util.Stack;

public class Prob_StackWithGetMin {
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

    Stack<Integer> s;
    int min;

    Prob_StackWithGetMin(){
        s=new Stack<>();
    }

    void push(int x) {

        if(s.isEmpty() ) {
            min=x;
            s.add(x);
        }
        else if(x<=min){
            s.add(2*x-min);
            min=x;
        }else{
            s.add(x);
        }
    }

    int pop() {

        int t=s.peek();s.pop();
        if(t<=min){
            int res=min;
            min=2*min-t;
            return res;
        }else{
            return t;
        }
    }

    int peek() {
        int t=s.peek();
        return ((t<=min)? min : t);
    }

    int getMin() {
        return min;
    }

    public static void main(String[] args)
    {
        Prob_StackWithGetMin s=new Prob_StackWithGetMin();;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin() );

    }
}
