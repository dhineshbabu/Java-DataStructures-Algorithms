package datastructures.trie;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    // main TrieNode class
    static class TrieNode
    {


        TrieNode[] children = new TrieNode[ALPHABET_SIZE];


        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    // search operation
    static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            // get the index (ascii)
            int index = key.charAt(i)-'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    // insert operation

    static void insert(String key){
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i)-'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public static void main(String[] args) {
        String keys[] = {"bad", "bat", "geeks", "geeks", "cat",
                "cut"};

        String output[] = {"NO", "YES"};

        root = new TrieNode();
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        if(search("bad") == true)
            System.out.println("bad --- " + output[1]);
        else System.out.println("bad --- " + output[0]);

        if(search("geeks") == true)
            System.out.println("geeks --- " + output[1]);
        else System.out.println("geeks --- " + output[0]);

        if(search("ca") == true)
            System.out.println("ca --- " + output[1]);
        else System.out.println("ca --- " + output[0]);


    }

}
