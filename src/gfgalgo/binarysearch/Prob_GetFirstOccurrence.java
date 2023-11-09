package gfgalgo.binarysearch;

public class Prob_GetFirstOccurrence {

    // we need to do normal binary search and handle case if the identified element is not a first occurrence
    // refer teh final else block
    static int firstOcc(int arr[], int n, int x)
    {
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if (x > arr[mid])
                low = mid + 1;

            else if (x < arr[mid])
                high = mid - 1;

            else {
                if(mid ==0 || (arr[mid-1] != arr[mid])){
                    // then this is the first occurrence
                    return mid;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
}

    public static void main(String args[])
    {
        int arr[] = {5, 10, 10, 10, 20}, n = 5;

        int x = 10;

        System.out.println(firstOcc(arr, n, x));
    }
}
