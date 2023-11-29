package gfgalgo.linkedlist;
import java.util.*;

public class Prob_11LRUCache {
    // Initialize a dummy head and tail for easy insertion and removal
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    // Use a HashMap to store key-value pairs for quick access
    Map<Integer, Node> map = new HashMap();

    // Capacity of the LRUCache
    int capacity;

    // Constructor to initialize the LRUCache with a given capacity
    public Prob_11LRUCache(int _capacity) {
        capacity = _capacity;
        // Connect the dummy head and tail to form an empty doubly linked list
        head.next = tail;
        tail.prev = head;
    }

    // Retrieve the value associated with a key in the LRUCache
    public int get(int key) {
        if (map.containsKey(key)) {
            // If the key is present, move the corresponding node to the front
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            // If the key is not present, return -1
            return -1;
        }
    }

    // Add or update a key-value pair in the LRUCache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If the key is already present, remove the corresponding node
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            // If the LRUCache is at full capacity, remove the least recently used node (tail.prev)
            remove(tail.prev);
        }
        // Insert the new node at the front of the doubly linked list
        insert(new Node(key, value));
    }

    // Remove a node from the doubly linked list
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node at the front of the doubly linked list
    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    // Node class representing a node in the LRUCache
    class Node {
        Node prev, next;
        int key, value;

        // Constructor to initialize a node with a key and value
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
