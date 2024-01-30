package gfgalgo.module08hashing;

import java.util.HashSet;

public class Prob_04IntersectionOfUnorderedArray {
    /*
    Question also states that we need to print in the same order in array 1

    Not writing the code here

    steps
    1. add all the elements of second array in hashset
    2. loop through elements in first array and then check if it is hashset
        if yes then print
     */

    public static void main(String[] args) {
        int a[] = {10, 20, 30};
        int[] b = {30, 10};

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < b.length; i++) {
            hs.add(i);
        }

        // loop through the second array now

        for (int i = 0; i < a.length; i++) {
            if (hs.contains(i)) {
                System.out.println(a[i]);
            }
        }
    }
}
