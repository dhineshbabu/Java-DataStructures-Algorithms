package gfgalgo.binarysearch;

public class Prob_02GetFirstOccurrence {

    // we need to do normal binary search and handle case if the identified element is not a first occurrence
    // refer teh final else block
    static int firstOcc(int arr[], int n, int x) {
        // Initialize low and high pointers
        int low = 0, high = n - 1;

        // Continue the search until the low pointer is less than or equal to the high pointer
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;

            // If the target element is greater than the middle element,
            // narrow the search to the right half of the array
            if (x > arr[mid])
                low = mid + 1;

                // If the target element is less than the middle element,
                // narrow the search to the left half of the array
            else if (x < arr[mid])
                high = mid - 1;

                // If the target element is equal to the middle element
            else {
                // Check if this is the first occurrence of the target element
                if (mid == 0 || (arr[mid - 1] != arr[mid])) {
                    // If yes, return the index of the first occurrence
                    return mid;
                } else {
                    // If not, continue searching in the left half of the array
                    high = mid - 1;
                }
            }
        }

        // If the target element is not found in the array, return -1
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {5, 10, 10, 10, 20}, n = 5;

        int x = 10;

        System.out.println(firstOcc(arr, n, x));
    }
}
