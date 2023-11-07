package gfgalgo.arrays;

public class Prob_FindLargestElement {
    // Time complexity: ø(n)
    public static void main(String[] args) {
        int[] arr = {10,40,24,22,45};

        int res = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > arr[res]) {
                res = i;
            }
        }

        System.out.println(res+" "+ arr[res]);
    }
}
