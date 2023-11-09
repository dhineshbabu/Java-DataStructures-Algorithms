package gfgalgo.binarysearch;

public class Basic_BS {

    // Time complexity: O(logn)

    static int bSearch(int[] arr, int item) {
        int low = 0, high=arr.length-1;

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

    static int bSearchRec(int[] arr, int low, int high, int item) {
        // base case
        if(low > high) return -1;

        int mid = (low+high)  / 2;

        if(arr[mid] == item) {
            return mid;
        }else {
            return (arr[mid] > item )
                    ? bSearchRec(arr, low, mid-1, item)
                    : bSearchRec(arr, mid+1, high, item);
        }
    }


    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50, 65, 70};
        System.out.println(bSearch(arr, 65));
        System.out.println(bSearchRec(arr, 0, arr.length-1, 65));
    }
}
