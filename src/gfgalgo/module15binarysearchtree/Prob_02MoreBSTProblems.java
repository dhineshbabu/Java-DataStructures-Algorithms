package gfgalgo.module15binarysearchtree;

import java.util.*;

public class Prob_02MoreBSTProblems {
    /*
    idea is to maintain a lcount variable in Node class

    1. compare with lcount+1 with k
        * if same as root, return root
        * if greater, recur for left subtree with same k
        else recu fir right subtree with k as (k-lcount-1) - skipping all elements
     */

    private static class Node {
        int data;
        Node left, right;
        int lCount;

        Node(int x) {
            data = x;
        }

    }

    private static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        } else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }

    static int prev = Integer.MIN_VALUE;

    static boolean isBST(Node root) {
   /*
   if inorder traversal if sorted then it is BST
   in all the iterations check the previous value

   In a BST, for every node, the values in its left subtree are less than or equal to the node's value,
   and the values in its right subtree are greater than the node's value.
   The code uses an in-order traversal approach to check if the tree satisfies the conditions of a BST.
    */
        if (root == null) return true;

        // traverse to the leftmost node
        if (isBST(root.left) == false) return false;

        // Check if the current node's value is greater than the previous value
        if (root.data <= prev) return false;

        // Update the previous value to the current root's value
        prev = root.data;

        // Continue the in-order traversal to the right subtree
        return isBST(root.right);
    }


    // checking
    static Node previous = null, first = null, second = null;

    public static void fixBSTWith2Swpa(Node root) {

        /*
        Given a binary search tree with two swapped nodes, the task is to fix the binary search tree by swapping them back.
        Approach is doing an inorder traversal and if violation is there, then sert the first variable and set second
         */
        if (root == null)
            return;
        fixBSTWith2Swpa(root.left);
        if (previous != null && root.data < previous.data) {
            if (first == null)
                first = previous;
            second = root;
        }
        previous = root;

        fixBSTWith2Swpa(root.right);
    }


    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static boolean pairSum(Node root, int sum, HashSet<Integer> s) {
        /*
        Method 1:
            * Do an inorder traversal and put it in an array
            * use a 2 pointer approach to find the pair
        Method 2:
            * Hashing - since we are returning boolean, we can use HashSet
         */

        if (root == null) return false;

        if (pairSum(root.left, sum, s) == true) return true;

        if (s.contains(sum - root.data)) {
            return true;
        } else {
            s.add(root.data);
        }

        return pairSum(root.right, sum, s);

    }


    public static void vSumR(Node root, int hd, TreeMap<Integer, Integer> mp) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree with a decreased horizontal distance (hd)
        vSumR(root.left, hd - 1, mp);

        // Calculate the sum at the current horizontal distance
        int currentSum = (mp.get(hd) == null) ? 0 : mp.get(hd);
        mp.put(hd, currentSum + root.data);

        // Traverse the right subtree with an increased horizontal distance (hd)
        vSumR(root.right, hd + 1, mp);
    }

    public static void vSum(Node root) {
        // TreeMap to store vertical sums, where keys are horizontal distances
        TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();

        // Calculate vertical sums recursively starting from the root
        vSumR(root, 0, mp);

        // Print the vertical sums
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }


    // Function for vertical traversal of a binary tree
    public static void vTraversal(Node root) {
        // Using a queue for level order traversal
        Queue<Pair> q = new LinkedList<>();

        // Using a TreeMap to store nodes at each horizontal distance
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        // Enqueue the root with horizontal distance 0
        q.add(new Pair(root, 0));

        // Continue until the queue is not empty
        while (!q.isEmpty()) {
            // Dequeue a node and its horizontal distance
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // Add the current node's data to the corresponding horizontal distance in the TreeMap
            if (mp.containsKey(hd))
                mp.get(hd).add(curr.data);
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.data);
                mp.put(hd, al);
            }

            // Enqueue the left child with a decreased horizontal distance
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            // Enqueue the right child with an increased horizontal distance
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        // Print the nodes at each horizontal distance
        for (Map.Entry<Integer, ArrayList<Integer>> p : mp.entrySet()) {
            ArrayList<Integer> al = p.getValue();
            for (int x : al)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    // Function for top view of a binary tree
    public static void topView(Node root) {
        // Using a queue for level order traversal
        Queue<Pair> q = new LinkedList<>();

        // Using a TreeMap to store the top view nodes at each horizontal distance
        Map<Integer, Integer> mp = new TreeMap<>();

        // Enqueue the root with horizontal distance 0
        q.add(new Pair(root, 0));

        // Continue until the queue is not empty
        while (!q.isEmpty()) {
            // Dequeue a node and its horizontal distance
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // If the horizontal distance is not in the TreeMap, add it
            if (!mp.containsKey(hd)) {
                mp.put(hd, curr.data);
            }

            // Enqueue the left child with a decreased horizontal distance
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            // Enqueue the right child with an increased horizontal distance
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        // Print the nodes at each horizontal distance (top view)
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

    // Method to print the bottom view of a binary tree
    public static void bottomView(Node root) {
        // Using a queue to perform level order traversal
        Queue<Pair> q = new LinkedList<>();

        // Using a TreeMap to store the horizontal distance and the corresponding node's data
        Map<Integer, Integer> mp = new TreeMap<>();

        // Adding the root node to the queue with horizontal distance 0
        q.add(new Pair(root, 0));

        // Loop through the nodes in level order
        while (q.isEmpty() == false) {
            // Dequeue the pair containing the current node and its horizontal distance
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // Update the TreeMap with the latest node's data for the current horizontal distance
            mp.put(hd, curr.data);

            // Enqueue the left child with a decreased horizontal distance
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            // Enqueue the right child with an increased horizontal distance
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        // Print the bottom view nodes in the order of their horizontal distances
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }


    public static void main(String[] args) {
        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};

        for (int x : keys)
            root = insert(root, x);


        Node res = kthSmallest(root, 3);
        if (res == null)
            System.out.println("There are less "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res.data);

        System.out.println(isBST(root));

        inorder(root);
        System.out.println();

        //fix nodes
        Node root1 = new Node(18);
        root1.left = new Node(60);
        root1.right = new Node(70);
        root1.left.left = new Node(4);
        root1.right.left = new Node(8);
        root1.right.right = new Node(80);


        fixBSTWith2Swpa(root1);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        inorder(root1);
        System.out.println();

        HashSet<Integer> s = new HashSet<>();


        System.out.println(pairSum(root, 26, s));
    }
}
