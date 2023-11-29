package gfgalgo.binarysearchtree;

public class Prob_01BasicBST {
    static class Node {
        Node left, right;
        int key;

        Node(int x){
            key = x;
        }
    }
    static boolean search(Node root, int x){
        // recursive
        if(root == null) return false;
        else if(root.key == x) return true;
        else if(x > root.key) {
            return search(root.right, x);
        } else {
            return search(root.left, x);
        }
    }

    static Node insert(Node root, int x) {
        // If the current node is null, create a new node with the given value
        if (root == null) {
            return new Node(x);
        }

        // If the value to be inserted is greater than the current node's value,
        // recursively insert into the right subtree
        if (x > root.key) {
            root.right = insert(root.right, x);
        }
        // If the value to be inserted is less than the current node's value,
        // recursively insert into the left subtree
        else if (x < root.key) {
            root.left = insert(root.left, x); // Assigning to make a link
        }

        // Return the root of the updated tree
        return root;
    }

    static Node insertIterative(Node root, int x) {
        Node temp = new Node(x);
        Node parent = null, curr = root;
        while(curr != null) {
            // finding parent in this loop
            parent = curr;
            if(curr.key > x) {
                curr = curr.left;
            } else if(curr.key < x) {
                curr = curr.right;
            } else {
                return root; // if key is already there in the key the dont make any change
            }
        }

        if(parent == null) {
            // there is only one node
            return temp;
        }

        if(parent.key > x) {
            parent.left = temp;
        } else
        {
            parent.right = temp;
        }
        return root;
    }

    // delete
    /*
    Deleting leaf node doesn't need any change to the tree structure
    else changes to be made

    if deleting a non-leaf node, then the node can be replaced with closes higher or closes lower value

    For getting the closest higher value, we can pick the inorder successor
     */

    static Node getSuccessor(Node root) {
        Node curr= root.right;

        while(curr != null && curr.left!= null) {
            // find the left most children
            curr = curr.left;
        }

        return curr;
    }

    static Node deleteRec(Node root, int x){
        // we use find successor helper method
        if(root == null) return null;

        if(root.key > x) {
            root.left = deleteRec(root.left, x);
        } else if(root.key < x) {
            root.right = deleteRec(root.right, x);
        } else {
            // if the node is the one to be deleted
            // check if they hae any one children then simply use the children as the node
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                // if the node to be deleted is having both the children
                // then find the successor using the helper method
                Node succ = getSuccessor(root);
                //replace the root key with successsor key
                root.key = succ.key;
                //delete the succ node
                root.right = deleteRec(root.right, succ.key);
            }
        }
        return root;
    }

    static Node floor(Node root, int x){
        Node res = null;

        while(root != null) {
            if(root.key == x) {
                return root;
            } else if(root.key > x) {
                root = root.left;
            } else {
                // update the res variable as this root or right side will be the floor
                res = root;
                root = root.right;
            }
        }

        return res;
    }

    static Node ceil(Node root, int x){
        Node res = null;

        while(root != null) {
            if(root.key == x) {
                return root;
            } else if(root.key < x) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    /*
    print kth smallest element
     */
    static void printKthElementSmall(Node root, int k){
       // refer the problem in another code

    }



    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);

        System.out.println(search(root, 18));
        System.out.println(search(root, 100000));

        //insert
        root = insert(root, 90);
        System.out.println(root.key);
        System.out.println("Floor: "+ floor(root, 12).key);
        System.out.println("Ceil: "+ ceil(root, 18).key);
    }
}
