package gfgalgo.module08hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChainingImplementation {
    /*
    THis is demo implementation for reference

     */

    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    ChainingImplementation(int b) {
        BUCKET = b; // assuming that the bucket size is provided by the user
        table = new ArrayList<>();
        // add an empty LinkedList to the array list for chaining
        for (int i = 0; i < b; i++) {
            table.add(new LinkedList<Integer>());
        }

    }

    void insert(int key) {
        int i = key % BUCKET;
        table.get(i).add(key); // add to the linked list at i in the array list
    }

    boolean search(int key) {
        int i = key % BUCKET;
        return table.get(i).contains(key);
    }

    void remove(int key) {
        int i = key % BUCKET;
        table.get(i).remove((Integer) i);
    }

}
