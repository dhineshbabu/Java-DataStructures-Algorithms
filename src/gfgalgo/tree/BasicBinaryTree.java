package gfgalgo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicBinaryTree {
    static class Node {
        int key;
        Node left;
        Node right;
        Node(int k){
            key = k;
        }
    }


    static void inorder(Node root){
        if(root!=null) {
            inorder(root.left);
            System.out.print(root.key+ " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root){
        if(root!=null) {
            System.out.print(root.key+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root!=null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+ " ");
        }
    }

    static int height(Node root) {
        if(root == null) return 0;

        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    static void printNodesAtDistanceK(Node root, int k){
        if(root == null) return;

        if(k==0) System.out.print(root.key+" ");

        else {
            printNodesAtDistanceK(root.left, k-1);
            printNodesAtDistanceK(root.right, k-1);
        }
    }

    static void BFS(Node root){
        /* we can leverage queue data structure for this

         */
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        //add the root
        q.add(root);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            System.out.print(curr.key+" ");
            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void BFSLineByLine(Node root){
        /* we can leverage queue data structure for this
       and also we can add null marker to mark the end of each level
         */
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        //add the root
        q.add(root);
        q.add(null);

        while(q.size() > 1) {
            Node curr = q.remove();
            if(curr == null) {
                System.out.println(); // print a new line
                q.add(null); // push null to mark the end of the current level
                continue;
            }
            System.out.print(curr.key+" ");
            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void printSpiralMethod01(Node root) {
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        // maintain the reverse variable
        boolean reverse = false;
        q.add(root);
        while(!q.isEmpty()) {
            int count = q.size();

            for(int i=0; i<count; i++) {
                Node curr = q.poll();
                if(reverse) {
                    //add it to stack for reverse priting
                    s.push(curr.key);
                } else {
                    // print as it is
                    System.out.print(curr.key+ " ");
                }

                // add the direct left and right children to the queue for next iteration
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            // print the items in reverse if there is anything in the stackl
            if(reverse) {
                while(!s.isEmpty()) {
                    System.out.print(s.pop()+" ");
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

        if(root == null) return 0; // base case
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = getDiameter01(root.left);
        int d3 = getDiameter01(root.right);
        return Math.max(d1, Math.max(d2, d3));

    }

    public static int res = 0;

    static int getDiameter02(Node root) {
        /* using modified height method above */
        if(root == null) return 0;
        int lh = getDiameter02(root.left);
        int rh = getDiameter02(root.right);
        // calculate the max res in each recursive call
        res = Math.max(res, 1+rh+lh);
        return 1+Math.max(lh, rh);
    }

    public static Node lca(Node root, int n1, int n2){
        if(root==null)return null;
        if(root.key==n1||root.key==n2)
            return root;

        Node lca1=lca(root.left,n1,n2);
        Node lca2=lca(root.right,n1,n2);

        if(lca1!=null && lca2!=null)
            return root;
        if(lca1!=null)
            return lca1;
        else
            return lca2;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);


        // inorder
        inorder(root);
        System.out.println();
        System.out.println("preorder");
        preorder(root);
        System.out.println();
        System.out.println("postorder");
        postorder(root);
        System.out.println();
        printNodesAtDistanceK(root, 2);
        System.out.println();
        System.out.println("BFS");
        BFS(root);
        System.out.println("BFS Line By Line");
        BFSLineByLine(root);
        System.out.println();
        System.out.println("Spiral 1");
        printSpiralMethod01(root);
        System.out.println();
        System.out.println("Diameter:"+ getDiameter01(root));
        getDiameter02(root);
        System.out.println("Diameter: "+ res);
    }

}
