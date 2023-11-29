package gfgalgo.binarysearchtree;

import java.util.*;

public class Prob_02MoreBSTProblems {
    /*
    idea is to maintain a lcount variable in Node class

    1. compare with lcount+1 with k
        * if same as root, return root
        * if greater, recur for left subtree with same k
        else recu fir right subtree with k as (k-lcount-1) - skipping all elements
     */

   private static class Node{
        int data;
        Node left, right;
        int lCount;
        Node(int x){
            data = x;
        }

    }

    private static class Pair{
        Node node;
        int hd;
        Pair(Node n,int h){node=n;hd=h;}
    }

    public static Node insert(Node root, int x)
    {
        if (root == null)
            return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        }

        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    public static Node kthSmallest(Node root, int k)
    {
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
        */
       if(root == null) return true;

       // traverse to the left most node
        if(isBST(root.left) == false) return false;
        if(root.data <= prev) return false;
        // assign the prev to the current root
        prev = root.data;
        return isBST(root.right);
    }
    // checking
    static Node previous=null,first=null,second=null;
    public static void fixBSTWith2Swpa(Node root)
    {

        /*
        Given a binary search tree with two swapped nodes, the task is to fix the binary search tree by swapping them back.

         */
        if (root == null)
            return;
        fixBSTWith2Swpa(root.left);
        if(previous!=null && root.data<previous.data){
            if(first==null)
                first=previous;
            second=root;
        }
        previous=root;

        fixBSTWith2Swpa(root.right);
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
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

        if(root == null) return false;

        if(pairSum(root.left, sum , s) == true) return true;

        if(s.contains(sum-root.data)) {
            return true;
        } else {
            s.add(root.data);
        }

        return pairSum(root.right, sum, s);

    }

    public static void vSumR(Node root,int hd,TreeMap<Integer,Integer> mp){
        if(root==null)return;
        vSumR(root.left,hd-1,mp);
        int pSum=(mp.get(hd)==null)?0:mp.get(hd);
        mp.put(hd,pSum+root.data);
        vSumR(root.right,hd+1,mp);
    }

    public static void vSum(Node root){
        TreeMap<Integer,Integer> mp=new TreeMap<Integer,Integer>();
        vSumR(root,0,mp);
        for(Map.Entry sum: mp.entrySet())
            System.out.print(sum.getValue()+" ");
    }

    public static void vTraversal(Node root){
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();
        q.add(new Pair(root,0));
        while(q.isEmpty()==false){
            Pair p=q.poll();
            Node curr=p.node;
            int hd=p.hd;
            if(mp.containsKey(hd))
                mp.get(hd).add(curr.data);
            else{
                ArrayList<Integer> al=new ArrayList<>();
                al.add(curr.data);
                mp.put(hd,al);
            }
            if(curr.left!=null)
                q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right,hd+1));
        }
        for(Map.Entry<Integer,ArrayList<Integer>> p:mp.entrySet()){
            ArrayList<Integer> al=p.getValue();
            for(int x: al)
                System.out.print(x+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

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
        int temp=first.data;
        first.data=second.data;
        second.data=temp;
        inorder(root1);
        System.out.println();

        HashSet<Integer> s = new HashSet<>();


        System.out.println(pairSum(root, 26, s));
    }
}
