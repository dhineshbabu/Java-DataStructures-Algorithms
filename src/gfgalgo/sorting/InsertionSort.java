package gfgalgo.sorting;

import java.util.Arrays;

public class InsertionSort {
    /*
    - O(n^2)
    Inplace and Stable
    used in practice for small arrays (Tim sort and IntoSort)
    O(n) for best case

    Basics: maintain 2 parts (sorted and unsorted)
    start from i=1 and plaec the element in correct
     */
    public static void sort(int[] arr) {
    for(int i=1; i<arr.length-1; i++) {
        // set the key
        int key = arr[i];
        // j will be the previous element
        int j = i-1;

        // shift the elements
        while(j>=0 && arr[j] > key){
            // move the element to the left
            arr[j+1] = arr[j];
            j--;
        }
        // place the key variable in that position
        arr[j+1] = key;

    }
    }

    public static void main(String[] args) {
        int a[] = {10, 5, 8, 20, 2, 18};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
