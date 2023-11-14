package gfgalgo.tree;

import java.util.LinkedList;
import java.util.Queue;

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
    }

}
