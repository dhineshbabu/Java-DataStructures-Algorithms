package datastructures.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(4);
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();
        myDLL.printList();
        myDLL.append(5);
        myDLL.append(2);
        myDLL.append(6);
        myDLL.append(59);
        myDLL.printList();
        myDLL.removeLast();
        myDLL.printList();
        myDLL.prepend(56);
        myDLL.printList();
        myDLL.removeFirst();
        myDLL.printList();
        System.out.println(myDLL.get(2).value);
        System.out.println(myDLL.get(3).value);
        myDLL.set(2, 77);
        myDLL.printList();
        myDLL.insert(2, 45);
        myDLL.printList();
        myDLL.remove(4);
        myDLL.printList();
    }
}
