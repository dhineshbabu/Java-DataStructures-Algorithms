package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    public Stack() {
        height = 0;
    }

    public void getTop() {
        if(this.height == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("top is : " + this.top.value);
    }

    public void getHeight() {

        System.out.println("Height is : " + this.height);
    }

    public void printStack() {
        if(this.height == 0) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = this.top;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void push(int value) {
        Node newNode = new Node(value);
        if(this.height == 0) {
            this.top = newNode;
        } else {
            newNode.next = top;
            this.top = newNode;
        }
        this.height++;
    }

    public Node pop() {
        if(this.height ==  0) return null;

        Node temp = this.top;
        this.top = top.next;
        temp.next = null;
        this.height--;
        return  temp;
    }
}
