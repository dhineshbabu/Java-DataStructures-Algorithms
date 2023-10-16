package algorithms.recursion.rBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
     Node root;

     public boolean insert(int value){
          Node newNode = new Node(value);
          if(this.root ==  null) {
               this.root = newNode;
               return true;
          }
          Node temp = root;

          while(true){
               if(newNode.value ==  temp.value) return false;
               if(newNode.value < temp.value) {
                    if(temp.left == null) {
                         temp.left = newNode;
                         return true;
                    }
                    temp = temp.left;
               } else {
                    if(temp.right == null) {
                         temp.right = newNode;
                         return true;
                    }
                    temp = temp.right;

               }
          }


     }

     public boolean contains(int key){
//          if(this.root == null) return false;

          Node temp = this.root;

          while(temp != null) {
               if(key < temp.value){
                    temp = temp.left;
               } else if(key > temp.value){
                    temp = temp.right;
               } else  {
                    return true;
               }
          }
          return false;
     }

     // recursive version of the contains method
     private boolean rContains(Node currentNode, int value) {
          if(currentNode == null) return false;

          if(currentNode.value == value) return true;

          if(value < currentNode.value) {
               return rContains(currentNode.left, value);
          } else {
               return rContains(currentNode.right, value);
          }
     }

     public boolean rContains(int value) {
          return rContains(this.root, value);
     }

     private Node rInsert(Node currentNode, int value) {
          // base case
          if(currentNode == null) return new Node(value);

          if(value < currentNode.value) {
               currentNode.left = rInsert(currentNode.left, value);
          } else if (value > currentNode.value){
               currentNode.right = rInsert(currentNode.right, value);
          }
          return currentNode;
     }

     public void rInsert(int value){
          if(this.root == null) this.root=new Node(value);
          rInsert(this.root, value);
     }

     // recursive delete node
     private Node rDeleteNode(Node currentNode, int value) {
          if(currentNode ==  null) return null;

          if(value < currentNode.value) {
               currentNode.left = rDeleteNode(currentNode.left, value);
          } else if(value > currentNode.value) {
               currentNode.right = rDeleteNode(currentNode.right, value);
          } else {
               if(currentNode.left == null && currentNode.right == null) {
                    return null;
               } else if(currentNode.left == null) {
                    currentNode = currentNode.right;
               } else if(currentNode.right ==  null) {
                    currentNode = currentNode.left;
               } else {
                    // both child available for the node to be deleted
                    // replace the min value in the right subtree
                    int subTreeMin = minValue(currentNode.right);
                    currentNode.value = subTreeMin;
                    currentNode.right = rDeleteNode(currentNode.right, subTreeMin);
               }
          }
          return currentNode;
     }

     public void rDeleteNode(int value) {
          rDeleteNode(this.root, value);
     }

     // helper methods
     public int minValue(Node currentNode) {
          while(currentNode.left != null) {
               currentNode = currentNode.left;
          }
          return currentNode.value;
     }

     // BFS
     public ArrayList<Integer> BFS() {
         Node currentNode = this.root;
          Queue<Node> queue = new LinkedList<>();
          ArrayList<Integer> results = new ArrayList<>();
          queue.add(currentNode);

          while(queue.size() > 0) {
               currentNode = queue.remove();
               results.add(currentNode.value);
               if(currentNode.left != null) {
                    queue.add(currentNode.left);
               }
               if(currentNode.right != null) {
                    queue.add(currentNode.right);
               }
          }
          return results;
     }

     // DFS PreOrder
     public ArrayList<Integer> DFSPreOrder() {
          ArrayList<Integer> results = new ArrayList<>();

          class Traverse {
               Traverse(Node currentNode) {
                    results.add(currentNode.value);
                    if(currentNode.left != null) {
                         new Traverse(currentNode.left);
                    }
                    if(currentNode.right!= null) {
                         new Traverse(currentNode.right);
                    }
               }
          }
          new Traverse(this.root);
          return results;
     }

     // DFS PostOrder
     public ArrayList<Integer> DFSPostOrder() {
          ArrayList<Integer> results = new ArrayList<>();

          class Traverse {
               Traverse(Node currentNode) {

                    if(currentNode.left != null) {
                         new Traverse(currentNode.left);
                    }
                    if(currentNode.right!= null) {
                         new Traverse(currentNode.right);
                    }
                    results.add(currentNode.value);
               }
          }
          new Traverse(this.root);
          return results;
     }

     // DFS InOrder - Numerical order
     public ArrayList<Integer> DFSInOrder() {
          ArrayList<Integer> results = new ArrayList<>();

          class Traverse {
               Traverse(Node currentNode) {

                    if(currentNode.left != null) {
                         new Traverse(currentNode.left);
                    }
                    results.add(currentNode.value);

                    if(currentNode.right!= null) {
                         new Traverse(currentNode.right);
                    }

               }
          }
          new Traverse(this.root);
          return results;
     }
}
