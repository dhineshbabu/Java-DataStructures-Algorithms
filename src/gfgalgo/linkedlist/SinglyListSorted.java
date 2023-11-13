package gfgalgo.linkedlist;

public class SinglyListSorted {


    static Node insertBegin(Node head, int data){
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node insertEnd(Node head, int data) {
        // we need to traverse to the last node
        Node temp = new Node(100);

        if(head == null) {
            return temp;
        }

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    static Node deleteBegin(Node head) {
        if(head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    static Node deleteEnd(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) return null;

        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }

    // insert at the given position
    static Node insertAt(Node head, int index, int data){
        Node temp = new Node(data);

        // assume index starts at 1
        if(index == 1) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        for(int i=1; i<index-2 && curr != null; i++) {
            curr = curr.next;
            //curr points to the previous index node
        }
        if(curr == null) return head;

        temp.next = curr.next;
        curr.next = temp;
        return head;

    }

    static void printList(Node head) {
        // get the head
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    //Recursive implementation
    static void printListRecusrive(Node head) {
        //base case
        if (head == null) {
            System.out.println("null");
            return;
        }

        System.out.print(head.data + " -> ");
        printListRecusrive(head.next);
    }

    static int search(Node head, int x) {
        int pos = 1;
        if(head == null) return -1;
        Node curr = head;

        while(curr.next != null) {
            if(curr.data == x) {
                return pos;
            }
            curr = curr.next;
            pos++;
        }
        return -1;
    }

    static int searchRecursive(Node head, int x) {
        if(head == null) return -1;

        if(head.data == x) return 1;

        else {
            int res = searchRecursive(head.next, x);
            if(res == -1) return -1;
            else return (res + 1);
        }
    }

    static Node sortedInsert(Node head, int data){
        Node temp = new Node(data);

        if(head == null) return temp;

        if(data < head.data) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        // traerse through LL until node.data < x
        while(curr.next != null && curr.next.data < data) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    static void removeDuplicate(Node head) {
        // check current and current next data if they are same
        Node curr = head;

        while(curr != null && curr.next != null) {
            if(curr.data == curr.next.data) {
                // unlink the next node;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }




    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        printList(head);
        head = sortedInsert(head, 35);
        head = sortedInsert(head, 30);

        printList(head);
        removeDuplicate(head);
        printList(head);

    }
}
