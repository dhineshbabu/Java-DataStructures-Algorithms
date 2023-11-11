package gfgalgo.linkedlist;

/*
data and next
 */

// Node class

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        // when we create a new node, it is automatically pointing to null
        // we have to map it to the right
        next = null;
    }
}
public class NodeDemo {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;
    }
}
