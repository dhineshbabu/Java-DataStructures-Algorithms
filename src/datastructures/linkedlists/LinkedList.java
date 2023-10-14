package datastructures.linkedlists;

public class LinkedList {
    private int length;
    private Node head;
    private Node tail;

    //Node class constructor
    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    // Linked List Constructor
    public LinkedList(int value) {
        this.length = 1;
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
    }

    public void printLinkedList() {
        Node temp = this.head;
        while(temp != null) {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void getHead() {
        System.out.println("Head is: " + this.head.value);
    }

    public void getTail() {
        System.out.println("Tail is: " + this.tail.value);
    }

    public void getLength() {
        System.out.println("Length is: " + this.length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        // if linked list is empty
        if(this.length == 0) return null;

        // if linked list is having only one element
        if (this.length == 1) {
            Node temp = this.head;
            this.head = null;
            this.tail = null;
            this.length--;
            return temp;
        }

        // if linked list is not empty and greater than one element
        Node temp = this.head;
        Node prev = this.head;

        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        this.tail = prev;
        this.tail.next = null;
        this.length--;
        return temp;
    }

    public Node removeFirst() {
        if(this.length == 0) {
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if(this.length == 0) {
            this.tail = null;
        }
        return temp;
    }

    // get from an index
    public Node get(int index) {
        if(index < 0 || index > this.length) {
            return null;
        }
        Node temp = this.head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // setting value for an index
    public boolean set(int index, int value) {
        Node temp = this.head;
        if(index < 0 || index > this.length) {
            return false;
        }
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    // inserting a value
    public boolean insert(int index, int value){
        if(index < 0 || index > this.length) {
            return false;
        }

        if(index == 0) {
            this.prepend(value);
            return true;
        }

        if(index == this.length) {
            this.append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length--;
        return true;
    }

    // removing an item from an index
    public Node remove(int index) {
        if(index < 0 || index > this.length) {
            return null;
        }
        if(index == 0) {
            return this.removeFirst();
        }

        if(index == this.length-1) {
            return this.removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;

    }

    public void reverse() {
        /*
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i=0; i<this.length;i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        */

        Node current = this.head;
        Node prev = null;
        Node next = null;

         while(current != null){
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
         }
         this.head = prev;
    }


}
