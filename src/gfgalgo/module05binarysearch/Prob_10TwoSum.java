package gfgalgo.module05binarysearch;

public class Prob_10TwoSum {


    /*
    // if it is sorted array then it is the best approach to use binary search else use hashing
    using 2 pointer approach
    if sum > x then j--
    else i++
    while(i<j)
     */
    static boolean twoSumSortedArray(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                return true;
            } else if ((arr[left] + arr[right]) < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {100, 150, 300, 450, 500, 550}, n = 6;

        int x = 600;

        System.out.println(twoSumSortedArray(arr, x));
    }
}
