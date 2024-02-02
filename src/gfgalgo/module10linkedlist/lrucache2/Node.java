package gfgalgo.module10linkedlist.lrucache2;

public class Node {
    Node prev;
    Node next;

    int value;
    int key;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
