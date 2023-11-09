package gfgalgo.arrays;

public class Prob_leaderinAnArray {
    /*
    Leader in an array is an element which will not have any equal or greater value on the right side of the element
     */

    public static void leader(int[] nums) {
        int n = nums.length;
        int currentLeader = nums[n-1];
        System.out.print(currentLeader);

        // move from the second last index
        for(int i=n-2; i>=0; i--){
            if(nums[i] > currentLeader) {
                currentLeader = nums[i];
                System.out.print(currentLeader);
            }
        }
    }

    public static void main(String[] args) {
        int nums[]  ={7,10,4,10,6,5,2};
        leader(nums);
    }

}
