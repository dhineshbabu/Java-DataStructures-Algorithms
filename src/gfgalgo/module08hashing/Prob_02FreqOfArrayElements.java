package gfgalgo.module08hashing;

import java.util.HashMap;
import java.util.Map;

public class Prob_02FreqOfArrayElements {
    static void count(int[] arr) {
        // initiate an hashmap
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            System.out.println("[" + e.getKey() + "," + e.getValue() + "]");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30};
        count(arr);
    }
}
