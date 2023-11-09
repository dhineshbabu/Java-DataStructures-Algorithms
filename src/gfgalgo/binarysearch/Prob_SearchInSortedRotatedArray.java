package gfgalgo.binarysearch;

public class Prob_SearchInSortedRotatedArray {

    /*
    in rotated sort find the middle, then either left or right will be sorted
    then compare the middle with left sorted side least index, if x > index, the skip the right half
    else skip the left half
     */
    static int search(int[] arr, int x) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == x) return mid;

            // left half sorted
            if(arr[low] <= arr[mid]) {
                if(x >= arr[low] && x< arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {
                // right half sorted
                if(x > arr[mid] && x <= arr[high])
                    low = mid+1;
                else
                    high=mid-1;
            }
        }

        return -1;
    }

    public static void main(String args[])
    {

        int arr[] = {100, 200, 400, 1000, 10, 20}, n = 6;

        int x = 10;

        System.out.println(search(arr, x));

    }
}
