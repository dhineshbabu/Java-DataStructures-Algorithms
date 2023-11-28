package gfgalgo.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Prob_17SortingEvenItemsFirst {
    public static void main(String[] args) {
        Integer[] arr = {5, 20, 10, 3, 12};
        Arrays.sort(arr, new MyCmp());
        System.out.println(Arrays.toString(arr)); //[20, 10, 12, 5, 3]
    }
}

class MyCmp implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a%2 - b%2;
    }
}
