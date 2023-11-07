package gfgalgo.arrays;

import java.util.Arrays;

public class Prob_MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {10,0,20,3,4,0,3,4};
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                // increment the count and this is the end of non-zero elements
                count++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
