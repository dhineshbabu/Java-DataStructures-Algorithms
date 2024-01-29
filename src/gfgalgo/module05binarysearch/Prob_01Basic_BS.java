package gfgalgo.module05binarysearch;

public class Prob_01Basic_BS {

    // Time complexity: O(logn)
    // Iterative binary search method

    static int bSearch(int[] arr, int item) {
        // Initialize low and high pointers
        int low = 0, high = arr.length - 1;

        // Continue the search until the low pointer is less than or equal to the high pointer
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;

            // Check if the middle element is equal to the target item
            if (arr[mid] == item) {
                // If found, return the index of the item
                return mid;
            } else if (arr[mid] > item) {
                // If the middle element is greater than the target item,
                // narrow the search to the left half of the array
                high = mid - 1;
            } else {
                // If the middle element is less than the target item,
                // narrow the search to the right half of the array
                low = mid + 1;
            }
        }

        // If the item is not found in the array, return -1
        return -1;
    }

    static int bSearchRec(int[] arr, int low, int high, int item) {
        // base case
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == item) {
            return mid;
        } else {
            return (arr[mid] > item)
                    ? bSearchRec(arr, low, mid - 1, item)
                    : bSearchRec(arr, mid + 1, high, item);
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 65, 70};
        System.out.println(bSearch(arr, 65));
        System.out.println(bSearchRec(arr, 0, arr.length - 1, 65));
    }
}
