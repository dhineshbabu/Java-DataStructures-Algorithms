package gfgalgo.stacks;

public class Prob_07KStacksInAnArray {

    int arr[];       // Array to store elements of multiple stacks
    int top[];       // Array to keep track of the top of each stack
    int next[];      // Array to keep track of the next available index in the array
    int cap, k;      // Capacity of the array and the number of stacks
    int freeTop;     // Index of the next available position in the array

    Prob_07KStacksInAnArray(int k1, int n) {
        k = k1; cap = n;
        arr = new int[cap];
        top = new int[k];
        next = new int[cap];

        // Initialize top of all stacks as -1 (indicating empty)
        for (int i = 0; i < k; i++)
            top[i] = -1;

        freeTop = 0;

        // Initialize next array to link all available positions in the array
        for (int i = 0; i < cap - 1; i++)
            next[i] = i + 1;
        next[cap - 1] = -1;
    }

    boolean isFull() {
        return (freeTop == -1);  // Check if there is no free position available
    }

    boolean isEmpty(int sn) {
        return (top[sn] == -1);  // Check if a specific stack is empty
    }

    void push(int x, int sn) {
        if (isFull()) {
            System.out.print("\nStack Overflow\n");
            return;
        }

        int i = freeTop;           // Get the next available position in the array
        freeTop = next[i];         // Update freeTop to the next available position
        next[i] = top[sn];         // Link the new element to the top of the stack
        top[sn] = i;               // Update top of the stack
        arr[i] = x;                // Store the element in the array
    }

    int pop(int sn) {
        if (isEmpty(sn)) {
            System.out.print("\nStack Underflow\n");
            return Integer.MAX_VALUE;
        }

        int i = top[sn];            // Get the index of the top element of the stack
        top[sn] = next[i];          // Update top of the stack
        next[i] = freeTop;          // Link the position to the next available position
        freeTop = i;                // Update freeTop to the current position
        return arr[i];              // Return the popped element
    }


    public static void main (String[] args) {

        int k = 3, n = 10;
        Prob_07KStacksInAnArray ks=new Prob_07KStacksInAnArray(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2) );
        System.out.println("Popped element from stack 1 is " + ks.pop(1) );
        System.out.println("Popped element from stack 0 is " + ks.pop(0) );

    }

}
