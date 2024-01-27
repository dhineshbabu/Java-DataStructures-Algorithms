package gfgalgo;

public class DemoClass {
    public static int subset(int[] arr, int n, int sum) {
        // base case
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        return subset(arr, n - 1, sum) + subset(arr, n - 1, sum - arr[n - 1]);
    }


    public static void main(String[] args) {


        int[] nums = {10, 20, 15, 5};
        int sum = 25;
        System.out.println(subset(nums, nums.length, sum));
    }
}
