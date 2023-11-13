package gfgalgo.linkedlist;

public class CircSinglyLL
{
    /*
    This class uses Node class of singly linked list
     */

    static void printList(Node head) {
        if(head == null) return ;

        // print the first node data
        System.out.print(head.data+ " -> ");
        // loop until the next node is head again
        for(Node r = head.next; r != head; r=r.next){
            System.out.print(r.data+ " -> ");
        }
        System.out.print("head ");
        System.out.println();
    }

    static Node insertBegin(Node head, int data) {
         Node temp = new Node(data);

         if(head == null) {
             temp.next = temp;
             return temp;
         }

         Node curr = head;
         while(curr.next != head){
             curr = curr.next;
         }
         curr.next = temp;
         temp.next = head;
         return temp;
    }

    static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);

        if(head == null) {
            temp.next = temp;
            return temp;
        }

        Node curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return head;
    }

    static Node deleteHead(Node head) {
        if(head == null) return null;
        if(head.next == head) return null;
        // just swap the data of the head node with head.next data and delete the head.next
        head.data = head.next.data;
        head.next = head.next.next;
        return head;

    }

    static Node deleteKthNode(Node head, int index){
        // traverse until index-2 times
        if(head == null) return head;

        if(index == 1) return deleteHead(head);

        Node curr = head;
        for(int i=0; i<index-2; i++) {
            curr = curr.next;
        }

        // set the next to it's next value
        curr.next = curr.next.next;
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(25);
        head.next.next.next.next = head; // pointing to head back again
        printList(head);
        head = insertBegin(head, 5);
        printList(head);
        head = insertEnd(head, 100);
        printList(head);
        head = deleteHead(head);
        printList(head);
        head = deleteKthNode(head, 3);
        printList(head);

    }
}

