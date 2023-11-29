package gfgalgo.linkedlist;

public class Prob_06FloydCycleDetectionLL {
    /*
    It uses 2 pointers - slow and fast
    slow moves 1 step
    fast moves 2 steps
    at a point slow and fast will meet then we will have a loop
     */


    static boolean isLoop(Node head) {
        // Initialize two pointers, slow_p and fast_p, both pointing to the head of the linked list
        Node slow_p = head, fast_p = head;

        // Traverse the linked list using two pointers (slow and fast) to detect a loop
        while (fast_p != null && fast_p.next != null) {
            // Move slow pointer one step at a time
            slow_p = slow_p.next;

            // Move fast pointer two steps at a time
            fast_p = fast_p.next.next;

            // Check if the slow pointer has met the fast pointer (loop detected)
            if (slow_p == fast_p) {
                return true; // There is a loop
            }
        }

        // If the loop completes without meeting pointers, there is no loop
        return false;
    }

    static void removeLoop(Node head) {
        /*
        steps
        1. Detect loop using Floyd's algorithm
        2. Move the slow pointer to the beginning of the loop of lined list and keep the fast pointer in the same place they met
        3. Now move slow and fast one by one at the same speed, the point where they meet now is the first node of the loop
         */
        Node slow = head, fast = head;

        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break; // there is a loop
            }
        }

        if(slow != fast) {
            return ; //there is no loop
        }

        // else move the slow pointer to the head
        slow = head;
        // loop until they are  equal
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    public static void main(String args[])
    {
        Node head=new Node(15);
        head.next=new Node(10);
        head.next.next=new Node(12);
        head.next.next.next=new Node(20);
        head.next.next.next.next=head.next; // here's the loop
        if (isLoop(head))
            System.out.print("Loop found");
        else
            System.out.print("No Loop");
    }

}
