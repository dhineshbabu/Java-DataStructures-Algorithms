package datastructures.dynamicprogramming;

import java.util.Arrays;

public class Prob_LonegestIncreasingSubsequence {
    /*
    idea 1:
    find the LIS for each element and get the maximum out of it
    create an LIS array
    Traverse through the LIS array and get the max value
     */

    static int LIS01(int[] arr) {
        int n = arr.length;

        // create LIS array
        int[] lis = new int[n];

        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        // now traverse through the lis array to get the max value
       int res = Arrays.stream(lis).max().orElseThrow();
        return res;

    }

    /*
    using binary search
    O(nlogn)
    idea is to build the tail array
    for each of the source array, replace it in the tail array after finding the ceiling value of it
     */

    static int LISBS(int[] arr) {
        int n = arr.length;
        int len = 1;
        //initiate tail array
        int[] tail = new int[n];
        tail[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i] > tail[len-1]){
                // if it is greater than the last, append
                tail[len] = arr[i];
                len++;
            } else {
                // call the ceiling function and replace with the ceil index
                int c = ceilIdx(tail, 0, len-1, arr[i]);
                tail[c] = arr[i];
            }
        }

        // length of the tail array will be the answer
        return len;
    }

    //create the ceiling function
    static int ceilIdx(int[] tail, int l, int r, int key) {
        while(r > l) {
            int mid = l+ (r-l) / 2;
            if(tail[mid] >= key ) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return r;
    }

    public static void main (String[] args)
    {
        int arr[] ={3, 4, 2, 8, 10, 5, 1};
        System.out.println(LIS01(arr));
        System.out.println(LISBS(arr));
    }
}
