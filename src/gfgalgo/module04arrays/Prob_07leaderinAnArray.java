package gfgalgo.module04arrays;

public class Prob_07leaderinAnArray {
    /*
    Leader in an array is an element which will not have any equal or greater value on the right side of the element
     */

    // Function to find and print the leaders in an array
    public static void leader(int[] nums) {
        int n = nums.length;

        // The rightmost element is always a leader
        int currentLeader = nums[n - 1];
        System.out.print(currentLeader);

        // Iterate from the second-to-last index towards the beginning of the array
        for (int i = n - 2; i >= 0; i--) {
            // Check if the current element is greater than the current leader
            if (nums[i] > currentLeader) {
                // If so, update the current leader and print it
                currentLeader = nums[i];
                System.out.print(" " + currentLeader);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {7, 10, 4, 10, 6, 5, 2};
        leader(nums);
    }

}
