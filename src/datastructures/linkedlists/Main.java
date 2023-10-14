package datastructures.linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printLinkedList();
        myLinkedList.append(1);
        System.out.println("*** after appending 1 ***");
        myLinkedList.printLinkedList();
        myLinkedList.append(6);
        myLinkedList.append(8);
        myLinkedList.printLinkedList();
        myLinkedList.removeLast();
        myLinkedList.printLinkedList();
//        myLinkedList.removeLast();myLinkedList.removeLast();myLinkedList.removeLast();
//        myLinkedList.printLinkedList();
//        myLinkedList.printLinkedList();
        myLinkedList.prepend(7);
        myLinkedList.printLinkedList();
        myLinkedList.removeFirst();
        myLinkedList.printLinkedList();
        System.out.println(myLinkedList.get(2).value);
        myLinkedList.set(2, 99);
        myLinkedList.printLinkedList();
        myLinkedList.insert(1,1);
        myLinkedList.printLinkedList();
        myLinkedList.remove(2);
        myLinkedList.printLinkedList();
        myLinkedList.reverse();
        myLinkedList.printLinkedList();
    }
}
