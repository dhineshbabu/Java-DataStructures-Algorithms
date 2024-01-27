package gfgalgo.module04arrays;

public class Prob_18FreqInSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 25, 30, 30};

        printFreq(arr);
    }

    public static void printFreq(int[] arr) {
        int n = arr.length;
        int freq = 1, i = 1;

        while (i < n) {
            while (i < n && (arr[i] == arr[i - 1])) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + ":" + freq);
            // reset the values
            freq = 1;
            i++;
        }
        // print either 1 element or element with 1 occurrence, also if final element is different than n-2
        if (n == 1 || (arr[n - 1] != arr[n - 2])) {
            System.out.println(arr[n - 1] + ":" + 1);
        }
    }
}
