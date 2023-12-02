package datastructures.trie;

// Class representing a TrieNode
class TrieNode {
    TrieNode[] child = new TrieNode[2]; // Array to store child nodes (0 and 1)
}

public class Prob_02CountDistinctRowInBinaryArray {

    /*
    idea is to create a modified tried with binary array as children
    maintain a res variable to count each unique trie branch creation
     */
    // Constants representing the dimensions of the matrix
    static final int M = 4, N = 3;

    // Input matrix
    static int mat[][] = {{1, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {0, 1, 0}};

    static TrieNode root; // Root of the Trie

    // Method to insert a row into the Trie
    static boolean insert(TrieNode root, int row) {
        TrieNode curr = root;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int index = mat[row][i];

            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
                flag = true; // Set the flag if a new node is created
            }

            curr = curr.child[index];
        }

        return flag; // Return true if a new row is inserted
    }

    // Method to count the number of distinct rows in the matrix
    static int countDis() {
        TrieNode root = new TrieNode(); // Create an empty Trie

        int res = 0;

        for (int row = 0; row < M; row++) {
            if (insert(root, row))
                res++; // Increment the count if a new row is inserted
        }

        return res; // Return the count of distinct rows
    }

    // Main method
    public static void main(String args[]) {
        // Print the count of distinct rows
        System.out.println(countDis());
    }
}
