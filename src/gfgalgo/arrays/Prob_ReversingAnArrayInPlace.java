package gfgalgo.arrays;

import java.util.Arrays;

public class Prob_ReversingAnArrayInPlace {
    public static void main(String[] args) {

        int[] arr = {1,3,4,5,5,6,60};
        int low = 0, high=arr.length-1;

        while(low < high) {
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
