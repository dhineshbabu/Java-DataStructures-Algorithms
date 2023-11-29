package gfgalgo.stacks;
// Node class

public class Prob_04StackWithLinkedList {
    /*
    Push and Pop will be happening at the head of LinkedList
     */

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class MyStack{
        Node head;
        int size;

        MyStack() {
            head = null;
            size = 0;
        }

        // operations
        int size() {
            return size;
        }

        boolean isEmpty (){
            return (head == null);
        }

        void push(int x){
            Node temp = new Node(x);
            temp.next = head;
            temp = head;
            size++;
        }

        int pop() {
            if(head == null) {
                return Integer.MAX_VALUE;
            }
            int res = head.data;
            head = head.next;
            size--;
            return res;
        }

        int peek() {
            if(head == null) {
                return Integer.MAX_VALUE;
            }

            return head.data;
        }
    }
}
