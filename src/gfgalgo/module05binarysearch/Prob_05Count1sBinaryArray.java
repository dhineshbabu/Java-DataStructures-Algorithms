package gfgalgo.module05binarysearch;

public class Prob_05Count1sBinaryArray {
    static int getCount(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid is 0 then we need to go to the right
            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                // then it is 1 , we need to find if it is the first occurrence
                if (mid == 0 || arr[mid - 1] == 0) {
                    return (n - mid); // this is the first occurrence
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] binArr = {0, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(getCount(binArr));
    }
}
