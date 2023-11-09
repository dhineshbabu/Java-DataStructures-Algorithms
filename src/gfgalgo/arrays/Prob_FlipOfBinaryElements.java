package gfgalgo.arrays;

public class Prob_FlipOfBinaryElements {

    /*
    if the array starts with 0 then the array groups will eiither end with group 0 or group 1
    so we can start to flip from the second group (if array starts with 0 then flip groups of 1 or vice versa)
     */
    static void binaryFlips(int[] arr) {

        int n = arr.length;

        for(int i=1; i<n; i++) {
            if(arr[i] != arr[i-1]) {
                if(arr[i] != arr[0]) {
                    System.out.print("From "+ i + " to ");
                } else {
                    System.out.println(i-1);
                }
            }
        }
        // final element changes
        if(arr[n-1] != arr[0]) {
            System.out.println(n-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,0,1};
        binaryFlips(nums);
    }
}
