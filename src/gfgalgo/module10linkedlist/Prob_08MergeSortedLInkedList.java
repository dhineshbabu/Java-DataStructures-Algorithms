package gfgalgo.module10linkedlist;

public class Prob_08MergeSortedLInkedList {
    /*
    pick the smaller head from both the linked lists
    main 4 pointers
        * head, tail
        * a, b
    head, tail will be initially pointing to the node which is smaller among the 2 linked lists
     */

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }


    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node head = null, tail = null;

        if (a.data < b.data) {
            head = a; // head is needed to return
            tail = a;
            a = a.next;
        } else {
            head = b;
            tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        // minimum list will meet the null first
        if (a == null) tail.next = b;
        else tail.next = a;

        return head;
    }


    public static void main(String args[]) {
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);
        Node b = new Node(5);
        b.next = new Node(35);
        printlist(sortedMerge(a, b));

    }
}
