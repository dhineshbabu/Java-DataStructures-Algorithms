package gfgalgo.arrays;

public class Prob_14MaxCircularSubArraySum {
    /*
    idea:
    1. minimum sum of normal subarray
    2. subtract the ( left of minimum sub array + right of minimum sub array)
     */

    // Function to find the maximum sum of a subarray without circular wrapping
    static int normalMaxSum(int arr[], int n) {
        int res = arr[0];
        int maxEnding = arr[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum ending at the current index
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            // Update the overall result to be the maximum of the previous result and the current maxEnding
            res = Math.max(maxEnding, res);
        }

        return res;
    }

    // Function to find the maximum sum of a subarray with circular wrapping
    static int overallMaxSum(int arr[], int n) {
        // Find the maximum sum of a subarray without circular wrapping
        int max_normal = normalMaxSum(arr, n);

        // If the maximum normal sum is negative, return it as the overall maximum sum
        if (max_normal < 0)
            return max_normal;

        int arr_sum = 0;

        // Calculate the total sum of the array and invert the sign of each element
        for (int i = 0; i < n; i++) {
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }

        // Find the maximum sum of a subarray with circular wrapping
        int max_circular = arr_sum + normalMaxSum(arr, n);

        // Return the maximum of the two sums (with and without circular wrapping)
        return Math.max(max_circular, max_normal);
    }

    public static void main(String args[]) {
        // Example array
        int arr[] = {8, -4, 3, -5, 4};
        int n = 5;

        // Print the overall maximum sum of subarrays (with or without circular wrapping)
        System.out.println(overallMaxSum(arr, n));
    }
}
