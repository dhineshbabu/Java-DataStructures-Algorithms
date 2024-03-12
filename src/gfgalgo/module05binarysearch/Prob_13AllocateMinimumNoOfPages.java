package gfgalgo.module05binarysearch;

public class Prob_13AllocateMinimumNoOfPages {
    /*
    We are provided with an array that represents the number of pages in each book, as well as the number of students available.
    Each student is required to read the books in a contiguous manner.
     Our objective is to determine the maximum number of pages that a single student needs to read in order to minimize the allocation.
     */


    // Function to check if it's feasible to allocate pages in a way that
    // each student gets at most 'ans' number of pages
    public static boolean isFeasible(int arr[], int n, int k, int ans) {
        int req = 1; // Number of students needed
        int sum = 0; // Cumulative sum of pages allocated

        for (int i = 0; i < n; i++) {
            // If the current sum of pages exceeds 'ans', allocate a new set of pages to a student
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                // Otherwise, continue adding pages to the current student
                sum += arr[i];
            }
        }

        // Check if the required number of students is less than or equal to 'k'
        return (req <= k);
    }

    // Function to find the minimum number of pages that can be allocated
    // such that each student gets at most 'k' pages
    public static int minPages(int arr[], int n, int k) {
        int sum = 0; // Total number of pages
        int mx = 0; // Maximum number of pages in a single book

        // Calculate the total sum of pages and the maximum number of pages in a single book
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mx = Math.max(mx, arr[i]);
        }

        int low = mx; // The minimum possible number of pages a student can get
        int high = sum; // The maximum possible number of pages a student can get
        int res = 0; // The result variable to store the minimum number of pages

        // Binary search to find the minimum number of pages
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if it's feasible to allocate pages in such a way that each student gets at most 'mid' pages
            if (isFeasible(arr, n, k, mid)) {
                res = mid;
                high = mid - 1; // Search for a lower value in the left half
            } else {
                low = mid + 1; // Search for a higher value in the right half
            }
        }

        // Return the minimum number of pages
        return res;
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 10, 30};
        int n = arr.length;
        int k = 2;

        System.out.print(minPages(arr, n, k));
    }
}

