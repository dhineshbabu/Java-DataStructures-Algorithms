package gfgalgo.module05binarysearch;

public class Prob_03GetLastOccurrence {

    // do the reverse of getfirstoccurrence problem in the final else block

    static int lastOcc(int arr[], int n, int x) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x > arr[mid])
                low = mid + 1;

            else if (x < arr[mid])
                high = mid - 1;

            else {
                if (mid == n - 1 || (arr[mid + 1] != arr[mid])) {
                    // then this is the last occurrence
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {5, 10, 10, 10, 20}, n = 5;

        int x = 10;

        System.out.println(lastOcc(arr, n, x));
    }
}
