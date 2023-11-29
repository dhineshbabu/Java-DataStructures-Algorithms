package gfgalgo.stacks;

public class Prob_01StackWithArrays {
    int[] arr;
    int capacity;
    int top;

    // constructor
    Prob_01StackWithArrays(int capacity){
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    // operations

    // push
    void push(int data){
        if(top == capacity-1){
            System.out.println("Overflow");
        }
        top++;
        arr[top] = data;
    }

    // pop
    int pop() {
        if(top == -1) {
            System.out.println("Underflow");
        }
        int data = arr[top];
        top--;
        return data;
    }

    int size() {
        return top+1;
    }

    boolean isEmpty(){
        return (top == -1);
    }

    int peek() {
        if(top == -1) {
            System.out.println("Underflow");
        }
        return arr[top];
    }
}

class Test {
    public static void main(String[] args) {
        Prob_01StackWithArrays stack = new Prob_01StackWithArrays(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

    }
}