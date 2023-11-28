package gfgalgo.arrays;

public class Prob_09TrappingRainWater {
    public static int getWater(int[] height) {
        // calculate leftmax and rightmax arrays
        // formula for final water calculation is
        // res = res + min(leftmax[i], rightmax[i]) - arr[i]

        int water = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // initiate the leftmax and rightmax variables

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        // populate the leftMax
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // populate the rightmax array
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // use the formula to calcualte the water content
        // we canot save any water on i=0 and i=n-1 positions, so the loop sgtarts from 1 and go until n-2
        for(int i=1; i<n-1; i++){
            water = water + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] heights = {5,0,6,2,3};
        System.out.println(getWater(heights));
    }
}
