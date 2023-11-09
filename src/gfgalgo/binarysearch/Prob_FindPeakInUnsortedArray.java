package gfgalgo.binarysearch;

public class Prob_FindPeakInUnsortedArray {

    /*
    Peak element is greater than both left and right element
    if the middle is lesser than left then assumption is that atleast one peak element will be there in the left
    if the middle is higher than left then assumption is that atleast one peak element will be there in the right

     */


        static int peak(int arr[])
        {
            int low = 0, high = arr.length - 1;

            while(low <= high)
            {
                int mid = (low + high) / 2;

                if((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                        (mid == arr.length - 1 || arr[mid + 1] <= arr[mid]))
                    return mid;
                if(mid > 0 && arr[mid - 1] >= arr[mid])
                    high = mid -1;
                else
                    low = mid + 1;
            }

            return -1;
        }


    public static void main(String[] args) {
        int arr[] = {100, 200, 400, 1000, 10, 20};


        System.out.println(peak(arr));
    }
}
