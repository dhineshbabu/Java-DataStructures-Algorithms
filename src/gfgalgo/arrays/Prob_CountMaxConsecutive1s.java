package gfgalgo.arrays;

public class Prob_CountMaxConsecutive1s {
    public static int count(int[] arr) {
         int tempCount = 0;
         int max = 0;
         for(int i=0; i<arr.length; i++) {
             if(arr[i] == 0) tempCount = 0;
             else {
                 tempCount++;
                 max = Math.max(max, tempCount);
             }
         }

         return max;
    }

    public static void main(String[] args) {
        int[] binaryNums = {1,1,1,0,0,0,1,1,1,1};
        System.out.println(count(binaryNums));
    }
}
