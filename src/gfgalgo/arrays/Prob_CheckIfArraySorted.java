package gfgalgo.arrays;

public class Prob_CheckIfArraySorted {

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,5,6,60};
        int first = 0, second=1;
        for(int i=0; i<arr.length-1; i++) {
            if (arr[first] <= arr[second]) {
                first++;
                second++;
            } else {
                System.out.println("Not sorted");
                return;
            }
        }

        System.out.println("Sorted");

    }
}
