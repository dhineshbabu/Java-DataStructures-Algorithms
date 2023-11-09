package gfgalgo.arrays;

public class Prob_MaxLengthEvenOddSubArray {

    // khaindens algorithm
    // have a start pointer and increament until it finds the combination
    // if the combination is done, then reset the start pointer

    public static int maxLengthEvenOdd(int[] arr) {
        int curr=1, result = 1;

        for(int i=1; i<arr.length; i++) {
            // check the alternate elements are even odd combination
            if((arr[i]%2 == 0 && arr[i-1] %2!=0) ||
                    (arr[i]%2 == 1 && arr[i-1] %2!=1) ) {
                curr++;
                result = Math.max(curr, result);
            } else {
                curr = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthEvenOdd(new int[] {5,10,20, 6,3,8}));


    }
}
