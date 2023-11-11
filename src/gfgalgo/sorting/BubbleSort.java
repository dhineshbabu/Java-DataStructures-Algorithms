package gfgalgo.sorting;

import java.util.Arrays;

public class BubbleSort {
    /*
    take each element and compare with adjacent element
    after 1st pass max element will go to the end

    use swapped variable to track the status

     */
    public static void sort(int[] arr){
        int n = arr.length;


        for(int i=0; i<n-1; i++) {
            boolean swapped = false;

            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    // set the swapped to true
                    swapped = true;
                }
            }
            // break the loop if there is no swap
            if(swapped == false) {
                break;
            }
        }

    }

    public static void main(String[] args) {

        int a[] = {2, 1, 4, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
