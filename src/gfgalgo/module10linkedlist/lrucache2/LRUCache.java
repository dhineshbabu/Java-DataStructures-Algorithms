package gfgalgo.module10linkedlist.lrucache2;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity, count;
    private Node head, tail;

    // constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        // The values will be inserted between head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    // method for get key operation
    public int get(int key) {
        // check if the key is there
        if (map.get(key) != null) {
            // then there is a key already available in the map. this will become the LRU item in the cache
            Node node = map.get(key);

            // Get the value in the node
            int result = node.value;

            // delete from the linked list
            deleteNode(node);
            // Move to the head of the linked list
            addToHead(node);

            System.out.println("Got the value for the key " + key + " : " + result);
            return result;
        }

        System.out.println("Did not get any value for the given key in the cache");
        return -1;
    }

    public void set(int key, int value) {
        System.out.println("Setting the value " + value + "for the key: " + key);

        // if the key is already available in the map then the value to be updated for the key
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            // add the new node based on the capacity of the cache
            Node node = new Node(key, value);
            // add the node to the map first
            map.put(key, node);
            // check the capacity
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                // remove the tail node as it is LRU and add the new node to the head as it is the MRU
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);

        // it will store a key (2) with value 20 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

        // removing key 2 and store a key (3) with value 30 in the cache.
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        // removing key 1 and store a key (4) with value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40
    }
}
