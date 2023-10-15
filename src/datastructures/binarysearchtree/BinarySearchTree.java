package datastructures.binarysearchtree;

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
}
