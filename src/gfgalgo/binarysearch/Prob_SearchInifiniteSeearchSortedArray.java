package gfgalgo.binarysearch;

public class Prob_SearchInifiniteSeearchSortedArray {

    /*
    we cannot navigate linearly, so i = i*2 for the next iteration (log(n))
    then apply binary search from
     */
    public static int search(int[] arr, int x) {
        if(arr[0] == x) return 0;

        int i=1;
        // move log(n)
        while(arr[i] < x) {
            i = i*2;
        }
        if(arr[i] == x) {
            return i;
        }

        // else do the binar search from i/2+1 to i-1
        return bSearch(arr, x, (i/2)+1, i-1);


    }

    static int bSearch(int[] arr, int item, int low, int high) {


        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[mid] == item) {
                return mid;
            } else if(arr[mid] > item) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
