package gfgalgo.sorting;

import java.util.Arrays;

public class SelectionSort {
    /*
    Does less memory writes
    It is the basic idea for heap sort
    Not stable
    Inplace algorithm
    idea is to find minimum element and move it to first, find 2nd minimum and move it to 2nd position, etc.

     */
    public static void sort(int[] arr) {
        int min_ind;
        for(int i=0; i<arr.length-1; i++){
            min_ind = i;
            // this for loop is opposite to bubble sort
            for(int j=i+1; j<arr.length-1;j++) {
                if(arr[min_ind] > arr[j]) {
                    min_ind = j;
                }
            }
            // swap the min_ind element with i position - moving to left
            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;

        }

    }

    public static void main(String[] args) {
        int a[] = {10, 5, 8, 20, 2, 18};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
