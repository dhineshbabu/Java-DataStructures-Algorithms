package gfgalgo.arrays;

public class Prob_MaxSumOfSubArrays {

    // Problem of sliding window technique
    // sub arrays are consecutive elements
    // naive solution: nested loops and maintain a result, chek the max at each iteration
    public static int maxSumOfSubArrays(int[] arr ){

        int result = 0;
        int maxEnding  = arr[0];

        // loop through from the second element and calculate the maxEnding
        // basically it is accumulating value with sliding window
        for(int i=1; i<arr.length; i++) {
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            // calculate the current maz result
            result = Math.max(result, maxEnding);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-8,7,-1,2,3};
        System.out.println(maxSumOfSubArrays(nums));
    }
}
