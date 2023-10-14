package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void getHead() {
        System.out.println("Head is : " +this.head.value);
    }

    public void getTail() {
        System.out.println("Tal is: " + this.tail.value);
    }

    public void getLength() {
        System.out.println("Length is: " + this.length);
    }

    public void printList() {
        Node temp = this.head;

        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if(this.length == 0) return null;
        Node temp = this.tail;
        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            // Linked list contains multiple elements
            this.tail = temp.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public Node removeFirst() {
        if(this.length == 0) return null;

        Node temp = this.head;
        if(this.length == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public Node get(int index) {
        if(index < 0 || index >= this.length) return null;
        Node temp = this.head;
        if(index < this.length /2) {
            for(int i=0; i<index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for(int i=this.length-1; i>index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = this.get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > this.length) return false;

        if(index == 0) {
            this.prepend(value);
            return true;
        }

        if(index == this.length) {
            this.append(value);
            return true;
        }

        // inserting when there are more than one element
        Node newNode = new Node(value);
        Node before = this.get(index-1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        this.length++;

        return true;

    }

    public Node remove(int index) {
        if (index < 0 || index > this.length) return null;

        if (index == 0) {
            return this.removeFirst();
        }

        if (index == length - 1) {
            return this.removeLast();
        }
        // removing somewhere in the middle
        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        this.length--;
        return temp;
    }
}
