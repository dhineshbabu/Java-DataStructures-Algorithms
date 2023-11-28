package gfgalgo.binarysearch;

public class Prob_11TripletInSortedArray {

    /*
    no need to be arrays can be any combinations

    select 1 element then use the twoSum technique to calculate the next 2 pair in the rest of the array


     */

    static boolean twoSumSortedArray(int[] arr, int sum, int startIndex) {
        int left = startIndex, right = arr.length-1;
        while(left < right) {
            if(arr[left] + arr[right] == sum) {
                return true;
            } else if((arr[left] + arr[right]) < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }



    static boolean triplets(int[] arr, int sum) {
        for(int i=0; i<arr.length-2; i++) {
            if(twoSumSortedArray(arr, sum-arr[i], i+1 )) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,10,15,18};

        int x = 33;

        System.out.println(triplets(arr, x));
    }
}
