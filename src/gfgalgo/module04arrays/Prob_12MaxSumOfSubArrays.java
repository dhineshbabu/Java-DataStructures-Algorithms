package gfgalgo.module04arrays;

public class Prob_12MaxSumOfSubArrays {

    // Problem of sliding window technique
    // sub arrays are consecutive elements
    // naive solution: nested loops and maintain a result, chek the max at each iteration
    public static int maxSumOfSubArrays(int[] arr) {

        int result = 0;
        int maxEnding = arr[0];

        // loop through from the second element and calculate the maxEnding
        // basically it is accumulating value with sliding window
        for (int i = 1; i < arr.length; i++) {
            // Calculate the maximum sum ending at the current index
            // It is the maximum of the sum of the previous maxEnding and the current element,
            // or simply the current element itself if the previous maxEnding is negative.
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            // Update the overall result to be the maximum of the previous result and the current maxEnding
            result = Math.max(result, maxEnding);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSumOfSubArrays(nums));
    }
}
