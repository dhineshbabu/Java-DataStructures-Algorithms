package gfgalgo.binarysearch;

public class Prob_04NoOfOccurrencesInSortedArray {

    // The idea is to leverage the getFirstOccurrence and getLastOccurrence methods and subtract the results + 1

    static int firstOcc(int arr[], int n, int x)
    {
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(x > arr[mid])
                low = mid + 1;

            else if(x < arr[mid])
                high = mid - 1;

            else
            {
                if(mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;

                else
                    high = mid - 1;
            }

        }

        return -1;
    }

    static int lastOcc(int arr[], int n, int x)
    {
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(x > arr[mid])
                low = mid + 1;

            else if(x < arr[mid])
                high = mid - 1;

            else
            {
                if(mid == n - 1 || arr[mid + 1] != arr[mid])
                    return mid;

                else
                    low = mid + 1;
            }

        }

        return -1;
    }

    // actual functiuon
   static public int countOcc(int[] arr, int n, int x) {
        // get the first occurrence
        int first = firstOcc(arr, n, x);
        if(first == -1)
            return 0;
        else
            // get the last occurrence and use the formula above
            return (lastOcc(arr, n, x) - first + 1);


    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 20, 20, 40, 40}, n = 6;

        int x = 20;

        System.out.println(countOcc(arr, n, x));
    }
}
