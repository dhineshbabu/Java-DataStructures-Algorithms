package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.getHeight();
        myStack.getTop();
        myStack.printStack();
        myStack.push(3);myStack.push(10);myStack.push(8);
        myStack.getTop();
        myStack.printStack();
        System.out.println(myStack.pop().value);
        myStack.printStack();
    }
}
