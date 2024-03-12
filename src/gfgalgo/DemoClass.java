package gfgalgo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DemoClass {

    public static void bubble(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3};
        bubble(a);
        System.out.println(Arrays.toString(a));


    }

}
