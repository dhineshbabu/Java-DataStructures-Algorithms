package gfgalgo.module08hashing;

import java.util.HashSet;
import java.util.Set;

public class Prob_06TwoSumBoolean {
    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 4};

        int sum = 13;

        //create an set to store the complements
        Set<Integer> s = new HashSet<>();

        //create hashmap
        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];
            if (s.contains(complement)) {
                System.out.println("True");
            } else {
                s.add(arr[i]);
            }
        }

    }
}
