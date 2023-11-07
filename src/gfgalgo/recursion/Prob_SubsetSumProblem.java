package gfgalgo.recursion;

public class Prob_SubsetSumProblem {
    /*
    this can be achieved with recursive solution
    for every element there will be 2 cases,
        1 with element
        1 without element
     */

    public static int subsetSumCunt(int[] nums, int n, int sum) {
        // define the base case
        // if the sum is 0 after all the recursive combinations then return 1
        // else return 0
        if(n==0) {
            return (sum==0) ? 1 : 0;
        }

        return subsetSumCunt(nums, n-1, sum) +
                subsetSumCunt(nums, n-1, sum-nums[n-1]);
    }

    public static void main(String[] args) {
        int[]  nums= {10, 20, 15};
        int sum = 25;
        System.out.println(subsetSumCunt(nums, nums.length, sum));
    }
}
