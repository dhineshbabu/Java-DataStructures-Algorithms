package gfgalgo.module11stacks;

public class Prob_02TwoStacksInAnArray {
    /*
    Begin from both ends of the array
    top1 top2
     */

    private int[] arr;
    private int capacity, top1, top2;

    // constructor
    Prob_02TwoStacksInAnArray(int n) {
        capacity = n;
        top1 = -1;
        top2 = n;
        arr = new int[n];
    }

    boolean push1(int x) {
        if (top1 < top2) {
            top1++;
            arr[top1] = x;
            return true;
        }
        return false;
    }

    boolean push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
            return true;
        }

        return false;
    }

    Integer pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        return null;
    }

    Integer pop2() {
        if (top2 < capacity) {
            int x = arr[top2];
            top2++;
            return x;
        }
        return null;
    }

    int size1() {
        return top1 + 1;
    }

    int size2() {
        return capacity - top2;
    }


}
