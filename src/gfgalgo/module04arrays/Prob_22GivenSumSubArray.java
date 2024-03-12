package gfgalgo.module04arrays;

public class Prob_22GivenSumSubArray {

    //efficient solution is to use sliding window technique
    // have start and end pointers
    // increase end pointer and sum
    // if sum is higher than increase start, if sum is smaller than increase the end
    static boolean IsSubArraySum(int[] arr, int sum) {

        int start = 0, curr = 0;
        for (int end = 0; end < arr.length; end++) {
            // add the end pointer to the current sum
            curr += arr[end];
            //check if curr is higher than sum, if yes then remove from start pointer
            while (sum < curr) {
                curr -= arr[start];
                start++;
            }
            if (curr == sum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(IsSubArraySum(new int[]{3, 2, 0, 4, 7}, 6));
    }
}
