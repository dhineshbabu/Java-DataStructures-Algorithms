package gfgalgo.module21trie;

public class Prob_01Trie {

    static final int ALPHABET_SIZE = 26;

    // main TrieNode class
    static class TrieNode {


        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        /*
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
         */
    }

    ;

    static TrieNode root;

    // search operation
    static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            // get the index (ascii)
            int index = key.charAt(i) - 'a';
            // check if any object available at that index
            if (curr.children[index] == null) return false;
            //if available, then navigate to search for the next character
            curr = curr.children[index];
        }
        //once the target string is reached (if available), then check the EndofWord flag
        return curr.isEndOfWord;
    }

    // insert operation

    static void insert(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            // get the ascii index
            int index = key.charAt(i) - 'a';
            // check if the index for the current char is not null then there is a character already available
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            // if already there, then navigate to the children node
            curr = curr.children[index];
        }

        // after the for loop it will mark the end, then set the flag EndOfWord as True
        curr.isEndOfWord = true;

    }


    // Method to remove a key from the trie
    static TrieNode remove(TrieNode root, String key, int i) {
        // Base case: If the root is null, return null
        if (root == null)
            return null;

        // If we have processed all characters of the key
        if (i == key.length()) {
            // If the current node represents the end of a word, mark it as not the end
            if (root.isEndOfWord)
                root.isEndOfWord = false;

            // If the current node is empty (has no children) after removing the key
            if (isEmpty(root)) {
                root = null; // Set the current node to null
            }

            return root;
        }

        // Get the index of the current character in the key
        int index = key.charAt(i) - 'a';

        // Recursively remove the next character from the trie
        root.children[index] = remove(root.children[index], key, i + 1);

        // If the current node is empty and not the end of a word, set it to null
        if (isEmpty(root) && !root.isEndOfWord) {
            root = null;
        }

        return root;
    }

    // Helper method to check if a TrieNode is empty (has no children)
    private static boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false; // If any child is not null, the node is not empty
            }
        }
        return true; // All children are null, so the node is empty
    }

    public static void main(String[] args) {
        String keys[] = {"bad", "bat", "geeks", "geeks", "cat",
                "cut"};

        String output[] = {"NO", "YES"};

        root = new TrieNode();
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        if (search("bad") == true)
            System.out.println("bad --- " + output[1]);
        else System.out.println("bad --- " + output[0]);

        if (search("geeks") == true)
            System.out.println("geeks --- " + output[1]);
        else System.out.println("geeks --- " + output[0]);

        if (search("ca") == true)
            System.out.println("ca --- " + output[1]);
        else System.out.println("ca --- " + output[0]);


    }

}
