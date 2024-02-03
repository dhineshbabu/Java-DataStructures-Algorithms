package gfgalgo.module14binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prob_01BasicBinaryTree {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
        }
    }


    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    static int height(Node root) {
        /*
        Height of Binary Tree is the number of nodes between the longest path from root to leaf node
        (including the root and leaf node)
         */
        if (root == null) return 0;

        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    static void printNodesAtDistanceK(Node root, int k) {
        /*
        Nodes at distance k from the root are basically the nodes at (k+1)th level of the Binary Tree.
         */
        if (root == null) return;

        if (k == 0) System.out.print(root.key + " ");

        else {
            printNodesAtDistanceK(root.left, k - 1);
            printNodesAtDistanceK(root.right, k - 1);
        }
    }

    // Breadth-First Search (BFS) traversal of a binary tree
    static void BFS(Node root) {
        /* We can leverage the queue data structure for this.
         * BFS is a level-order traversal algorithm, and a queue is used to keep track of the nodes at each level.
         * It starts from the root, processes the current level, and moves to the next level in a breadth-wise manner.
         */

        if (root == null) return; // Return if the tree is empty

        Queue<Node> q = new LinkedList<>(); // Create a queue to store nodes during traversal

        // Add the root to the queue to start the BFS
        q.add(root);

        // Continue BFS until the queue is empty
        while (!q.isEmpty()) {
            Node curr = q.remove(); // Remove the front node from the queue and process it
            System.out.print(curr.key + " "); // Print the key of the current node

            // Enqueue the left child if it exists
            if (curr.left != null) {
                q.add(curr.left);
            }

            // Enqueue the right child if it exists
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void BFSLineByLine(Node root) {
        /* we can leverage queue data structure for this
       and also we can add null marker to mark the end of each level
         */
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        //add the root
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println(); // print a new line
                q.add(null); // push null to mark the end of the current level
                continue;
            }
            System.out.print(curr.key + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    // size of binary tree
    public static int getSize(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + getSize(root.left) + getSize(root.right);
    }

    // get maximum value from a tree
    public static int getMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
    }

    // printing the leftview of a binary tree  -recursive (it has 2 methods printLeft and printLeftView)
    // it is basically , preorder traversal
    static int maxLevel = 0;

    public static void printLeft(Node root, int level) {
        // base case
        if (root == null) return;

        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        // recursive calls for preorder traversal with level+1
        printLeft(root.left, level + 1);
        printLeft(root.right, level + 1);
    }

    public static void printLeftView(Node root) {
        // call the above method
        printLeft(root, 1);
    }

    public static boolean isCSum(Node root) {
        /*
        Children Sum Property is a property in which the sum of values of the left child and right child should be
        equal to the value of their node if both children are present.
        Else if only one child is present then the value of the child should be equal to its node value.
         */
        // Check if the tree is empty or a leaf node
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        // Calculate the sum of left and right children's keys
        int sum = 0;
        if (root.left != null)
            sum += root.left.key;
        if (root.right != null)
            sum += root.right.key;

        // Check if the current node's key is equal to the sum of its children
        // Recursively check the left and right subtrees
        return (root.key == sum && isCSum(root.left) && isCSum(root.right));
    }


    static void printSpiralMethod01(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        // maintain the reverse variable
        boolean reverse = false;
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();

            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (reverse) {
                    //add it to stack for reverse priting
                    s.push(curr.key);
                } else {
                    // print as it is
                    System.out.print(curr.key + " ");
                }

                // add the direct left and right children to the queue for next iteration
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            // print the items in reverse if there is anything in the stackl
            if (reverse) {
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse; // change the reverse for the next iteration
            System.out.println();
        }

        // we can acheive the same using 2 stacks approach also
    }

    static int getDiameter01(Node root) {
        /*
        Diameter is the longest distance between any of the 2 leaf nodes in a binary tree
         */

        if (root == null) return 0; // base case
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = getDiameter01(root.left);
        int d3 = getDiameter01(root.right);
        return Math.max(d1, Math.max(d2, d3));

    }

    /*
    In a Balanced Binary Tree for every node,
    the difference between heights of left subtree and right subtree should not be more than one.
     */

    public static int isBalanced(Node root) {
        if (root == null)
            return 0;
        int lh = isBalanced(root.left);
        if (lh == -1) return -1;
        int rh = isBalanced(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    // get maxWidth of a tree

    public static int maxWidth(Node root) {

        /*
        Maximum Width of Binary tree is the maximum number of nodes present in a level of the Tree.
         */
        // Check if the tree is empty
        if (root == null)
            return 0;

        // Create a queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);

        // Initialize the variable to store the maximum width
        int res = 0;

        // Perform level order traversal
        while (q.isEmpty() == false) {
            // Get the number of nodes at the current level
            int count = q.size();
            // Update the maximum width if the current level has more nodes
            res = Math.max(res, count);

            // Process all nodes at the current level
            for (int i = 0; i < count; i++) {
                // Dequeue a node
                Node curr = q.poll();
                // Enqueue its left and right children if they exist
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        // Return the maximum width of the tree
        return res;
    }

    public static int res = 0;

    static int getDiameter02(Node root) {
        /* using modified height method above */
        if (root == null) return 0;
        int lh = getDiameter02(root.left);
        int rh = getDiameter02(root.right);
        // calculate the max res in each recursive call
        res = Math.max(res, 1 + rh + lh);
        return 1 + Math.max(lh, rh);
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.key == n1 || root.key == n2)
            return root;

        Node lca1 = lca(root.left, n1, n2);
        Node lca2 = lca(root.right, n1, n2);

        if (lca1 != null && lca2 != null)
            return root;
        if (lca1 != null)
            return lca1;
        else
            return lca2;
    }

    public static int getCOunt(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + getCOunt(root.left) + getCOunt(root.right);
    }

    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);


        // inorder
        System.out.println("inorder");
        inorder(root);
        System.out.println();
        System.out.println("preorder");
        preorder(root);
        System.out.println();
        System.out.println("postorder");
        postorder(root);
        System.out.println();
        System.out.println("height");
        System.out.println(height(root));
        System.out.println("Calling printNodesAtDistanceK()");
        printNodesAtDistanceK(root, 2);
        System.out.println();
        System.out.println("BFS");
        BFS(root);
        System.out.println("BFS Line By Line");
        BFSLineByLine(root);
        System.out.println();
        System.out.println("Calling getSize()");
        System.out.println(getSize(root));
        System.out.println("Calling printLeftView()");
        System.out.println("calling isCSum()");
        System.out.println(isCSum(root));
        printLeftView(root);
        System.out.println("Spiral 1");
        printSpiralMethod01(root);
        System.out.println();
        System.out.println("Diameter:" + getDiameter01(root));
        getDiameter02(root);
        System.out.println("Diameter: " + res);
        System.out.println("Max is " + getMax(root));
        System.out.println("Is balanced: " + isBalanced(root));
        System.out.println("Count is: " + getCOunt(root));
    }

}
