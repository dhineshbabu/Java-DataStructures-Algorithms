package gfgalgo.module04arrays;

public class Prob_01FindLargestElement {
    // Time complexity: ø(n)
    public static void main(String[] args) {
        int[] arr = {10, 40, 24, 22, 45};

        // keep the result variable for the placeholder index of the maximum number found so far
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }

        System.out.println(res + " " + arr[res]);
    }
}
