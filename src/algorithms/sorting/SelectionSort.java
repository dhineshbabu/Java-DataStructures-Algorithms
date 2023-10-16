package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++) {
            int minIndex = i;

            for(int j=i+1; j< arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] =temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {47, 21, 76, 18, 27, 52, 82};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
