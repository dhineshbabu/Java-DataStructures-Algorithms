package gfgalgo.module18greedyalgo;

import java.util.PriorityQueue;

class Node {
    char ch;
    int freq;
    Node right;
    Node left;

    public Node(char ch, int freq, Node right, Node left) {
        this.ch = ch;
        this.freq = freq;
        this.right = right;
        this.left = left;
    }
}

public class Prob_04HuffmanCoding {
    /*
    Used for lossless compression
    Variable Length coding

    1. Create lead nodes and build a MinHeap h of all the leaves initially
    2. while h.size() > 1
        a. left = h.extractMin()
        b. right = h.extractMin()
        c. Create a new tree node with
            character a $
            Frequency as left.freq + right.freq
            Left and right children as left and right respectively
        d. Insert the new node into h
     3. THe only node left in h is our required Binary tree
     */

    static void printHCodes(char[] arr, int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (n1, n2) -> n1.freq - n2.freq
        );

        // add all the values from arrays into the priority queues
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Node(arr[i], freq[i], null, null));
        }

        // do the calculation and construct the binary tree
        while (pq.size() > 1) {
            Node l = pq.poll();
            Node r = pq.poll();
            pq.add(new Node('$', l.freq + r.freq, l, r));
        }

        // pq's peek will have the maximum number now
        printRec(pq.peek(), "");
    }

    static void printRec(Node root, String s) {
        if (root.ch != '$') {
            System.out.println(root.ch + " " + s);
            return;
        }
        printRec(root.left, s + "0");
        printRec(root.right, s + "1");
    }

    public static void main(String[] args) {
        printHCodes(new char[]{'a', 'd', 'e', 'f'}, new int[]{30, 40, 80, 60});
    }
}
