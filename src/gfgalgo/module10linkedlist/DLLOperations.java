package gfgalgo.module10linkedlist;

public class DLLOperations {

    public static DLLNode insertBegin(DLLNode head, int data) {
        DLLNode temp = new DLLNode(data);
        if (head == null) {
            head = temp;
            return head;
        }

        temp.next = head;
        head.prev = temp;
        head = temp;
        return head;
    }

    public static DLLNode insertEnd(DLLNode head, int data) {
        DLLNode temp = new DLLNode(data);
        if (head == null) {
            head = temp;
            return head;
        }

        DLLNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static DLLNode reverse(DLLNode head) {
        //handle corner cases
        if (head == null || head.next == null) return head;
        DLLNode prev = null, curr = head;

        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            // move to the previous node
            curr = curr.prev;
        }
        return prev.prev;
    }

    static DLLNode deleteHead(DLLNode head) {
        if (head == null) return head;
        if (head.next == null) return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    static DLLNode deleteEnd(DLLNode head) {
        if (head == null) return head;
        if (head.next == null) return null;
        DLLNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;

    }

    static void printList(DLLNode head) {
        // get the head
        DLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        DLLNode head = new DLLNode(10);
        DLLNode temp1 = new DLLNode(20);
        DLLNode temp2 = new DLLNode(30);
        head.next = temp1;
        temp1.next = temp2;
        temp1.prev = head;
        temp2.prev = temp1;

        head = insertBegin(head, 5);
        head = insertEnd(head, 45);

        printList(head);

        //reverse
        head = reverse(head);
        printList(head);

        head = deleteHead(head);
        printList(head);

        head = deleteEnd(head);
        printList(head);
    }
}
