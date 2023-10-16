package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        for(int i=0; i < array.length-1; i++) {
            boolean swapped = false;
            for(int j=0; j<array.length-1; j++) {
                if(array[j]> array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
                System.out.println("loop " + j);
            }
            if(swapped ==  false) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {47, 21, 76, 18, 27, 52, 82};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
