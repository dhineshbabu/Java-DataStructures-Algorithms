package gfgalgo.module10linkedlist;

public class LinkedListOperations {


    static Node insertBegin(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node insertEnd(Node head, int data) {
        // we need to traverse to the last node
        Node temp = new Node(100);

        if (head == null) {
            return temp;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    static Node deleteBegin(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    static Node deleteEnd(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) return null;

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }

    // insert at the given position
    static Node insertAt(Node head, int index, int data) {
        Node temp = new Node(data);

        // assume index starts at 1
        if (index == 1) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        for (int i = 1; i < index - 2 && curr != null; i++) {
            curr = curr.next;
            //curr points to the previous index node
        }
        if (curr == null) return head;

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
        if (head == null) return -1;
        Node curr = head;

        while (curr.next != null) {
            if (curr.data == x) {
                return pos;
            }
            curr = curr.next;
            pos++;
        }
        return -1;
    }

    static int searchRecursive(Node head, int x) {
        if (head == null) return -1;

        if (head.data == x) return 1;

        else {
            int res = searchRecursive(head.next, x);
            if (res == -1) return -1;
            else return (res + 1);
        }
    }

    // finding the middle element
    static void middleElement(Node head) {
        if (head == null) return;

        // using slow and fast 2 pointers approach
        // slow moves 1 step = slow.next
        // fast moves 2 steps = slow.next.next
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // 2 steps
        }
        System.out.println(slow.data);

    }

    static Node reverse(Node head) {
        if (head == null) return null;

        if (head.next == null) return head;

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // make the last element as head
        head = prev;
        return head;
    }

    static void nthNode(Node head, int n) {
        // if we have length , then it is length-n+1 and loop starts from value 1 (i=1)
        // we can also 2 use pointers
        // pointer 1 points n positions from start (n is the item to find from last)
        // pointer 2 will start from head, each will move 1 position at a time
        // when pointer 1 reached the end or null, the second pointer points the required node

        if (head == null) return;

        Node first = head;
        // move this to nth possition
        for (int i = 0; i < n; i++) {
            // if fist reaches null before n then n is less than the length of LL
            if (first == null) return;
            first = first.next;
        }

        Node second = head;
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        System.out.println(second.data);

    }

    static Node reverseRecursive1(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        Node rest_head = reverseRecursive1(head.next);
        Node rest_tail = head.next; // second element
        rest_tail.next = head;
        head.next = null;
        head = rest_head;
        return head;
    }

    static Node reverseRecursive2(Node curr, Node prev) {
        // Base cases
        if (curr == null) return prev;

        Node next = curr.next;
        curr.next = prev;
        //exchange the curr and prev
        return reverseRecursive2(next, curr);
    }

    static Node reverseLLGroupOfSizeK(Node head, int k) {

        Node curr = head, prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null) {
            Node first = curr, prev = null;
            int count = 0;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            // if loop is only for first group iteration
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }

    public static boolean detectLoop(Node head) {
        // create a temp node and mark all the currnext to the temp
        // if any of the node's next is pointing temp then there is a loop
        // we can simplify the solution using hashset as well
        Node temp = new Node(Integer.MAX_VALUE); // dum my node
        Node curr = head;
        while (curr != null) {
            if (curr.next == null) {
                // no loop
                return false;
            }
            if (curr.next == temp) {
                // there is a loop
                return true;
            }
            // point to dummy node
            Node next = curr.next;
            curr.next = temp;
            curr = next;
        }

        return false;

    }

    // Delete a node with given pointer
    static void deleteWithGivenPointer(Node node) {
        Node temp = node.next;
        node.data = temp.data; //copy yhe next node data
        node.next = temp.next; // node.text.text;
    }

    // Insert a node in a sorted LL
    Node sortedInsert(Node head, int x) {
        Node temp = new Node(x);

        if (head == null) {
            return temp;
        }

        if (x < head.data) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    static Node segregateEvenOdd(Node head) {
        /*
        1. traverse through the LL and find the last node
        2. traverse again and place all odd nodes after the last and make the new node as the last node
        initialize 4 variables es, ee, os, oe
         */

        Node es = null, ee = null, os = null, oe = null;

        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;

            if (x % 2 == 0) {
                if (es == null) {
                    es = curr;
                    ee = curr;
                } else {
                    ee.next = curr;
                    ee = ee.next;
                }
            } else {
                if (os == null) {
                    os = curr;
                    oe = curr;
                } else {
                    oe.next = curr;
                    oe = oe.next;
                }
            }
        }

        // make the final changes
        ee.next = os;
        oe.next = null;
        return es; // as es will be the next head

    }


    public static void main(String[] args) {
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(41);
        Node ptr = new Node(80);
        head.next.next.next.next = ptr;
        head.next.next.next.next.next = new Node(50);
        printList(head);
        printListRecusrive(head);
        deleteWithGivenPointer(ptr);
        printList(head);
        head = insertBegin(head, 5);
        printList(head);
        head = insertEnd(head, 100);
        printList(head);
        head = deleteBegin(head);
        printList(head);
        head = deleteEnd(head);
        printList(head);
        System.out.println(search(head, 30));
        System.out.println(searchRecursive(head, 30));
        middleElement(head);
        nthNode(head, 2);
        head = reverse(head);
        printList(head);
        head = reverseRecursive1(head);
        printList(head);
        head = reverseRecursive2(head, null);
        printList(head);
        head = reverseLLGroupOfSizeK(head, 2);
        printList(head);
//        System.out.println(detectLoop(head)); - should be false
        printList(head);
        head = segregateEvenOdd(head);
        printList(head);


    }
}