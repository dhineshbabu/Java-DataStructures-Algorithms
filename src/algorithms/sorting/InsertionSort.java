package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;

            while(j > -1 && temp < arr[j]){
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = {47, 21, 76, 18, 27, 52, 82};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
