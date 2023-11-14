package gfgalgo.stacks;

import java.util.ArrayList;

public class StackWithArrayList {
    ArrayList<Integer> al = new ArrayList<>();

    void push(int x) {
        al.add(x);
    }

    int pop() {
        int data = al.get(al.size()-1);
        al.remove(al.size()-1);
        return data;
    }

    boolean isEmpty() {
        return al.isEmpty();
    }

    int peek() {
        return al.get(al.size()-1);
    }

    int size(){
        return al.size();
    }
}

class Test1 {
    public static void main(String[] args) {
        StackWithArrayList stack = new StackWithArrayList();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

    }
}