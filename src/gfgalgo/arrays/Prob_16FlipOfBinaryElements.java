package gfgalgo.arrays;

public class Prob_16FlipOfBinaryElements {

    /*

    Our Task: Given a binary array, we need to convert this array into an array that either contains all 1s or all 0s.  We need to do it using the minimum number of group flips.


    if the array starts with 0 then the array groups will either end with group 0 or group 1
    so we can start to flip from the second group (if array starts with 0 then flip groups of 1 or vice versa)
     */
    static void binaryFlips(int[] arr) {

        int n = arr.length;

        for(int i=1; i<n; i++) {
            // Check if the current binary digit is different from the previous one
            if(arr[i] != arr[i-1]) {
                // Check if the current binary digit is different from the first element
                if(arr[i] != arr[0]) {
                    // Print the start position of a flip
                    System.out.print("From "+ i + " to ");
                } else {
                    // Print the end position of a flip
                    System.out.println(i-1);
                }
            }
        }
        // final element changes - becuase previous loop ends at the n-1 position
        if(arr[n-1] != arr[0]) {
            System.out.println(n-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,0,1};
        binaryFlips(nums);
    }
}
