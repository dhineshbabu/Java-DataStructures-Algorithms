package datastructures.hashtables;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.printTable();
        ht.set("kani", 99);
        ht.set("perf", 5);
        ht.set("engg", 25);
        ht.set("bru", 85);
        ht.set("rbu", 26);
        ht.printTable();
        System.out.println(ht.get("bru"));
        System.out.println(ht.keys());
    }
}
