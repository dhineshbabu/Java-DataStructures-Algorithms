package datastructures.binarysearchtree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(91);
        bst.insert(2);
        bst.insert(17);
        bst.insert(35);
        bst.insert(87);
        bst.insert(20);
        System.out.println(bst.root.left.right.value);
        System.out.println();
        System.out.println(bst.contains(35));
        System.out.println(bst.contains(1100));
    }
}
