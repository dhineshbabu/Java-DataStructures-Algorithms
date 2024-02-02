package gfgalgo.module10linkedlist;


public class Prob_07Intersection2LInkedLists {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }

    int _getIntesectionNode(int d, Node node1, Node node2) {
        // Initialize pointers for traversing the linked lists
        Node current1 = node1;
        Node current2 = node2;

        // Step 1: Move the pointer of the longer linked list (node1) forward by 'd' nodes
        for (int i = 0; i < d; i++) {
            // If the end of the longer list is reached before 'd' nodes, no intersection is possible
            if (current1 == null) {
                return -1; // No intersection
            }
            // Move the pointer of the longer list forward
            current1 = current1.next;
        }

        // Step 2: Compare nodes of both linked lists starting from their aligned positions
        while (current1 != null && current2 != null) {
            // If a matching node is found, return its data value (intersection point)
            if (current1.data == current2.data) {
                return current1.data;
            }
            // Move both pointers forward in their respective linked lists
            current1 = current1.next;
            current2 = current2.next;
        }

        // If the loop completes without finding an intersection, return -1
        return -1;
    }


    int getCount(Node node) {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        Prob_07Intersection2LInkedLists list = new Prob_07Intersection2LInkedLists();

        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println(list.getNode());
    }
}


