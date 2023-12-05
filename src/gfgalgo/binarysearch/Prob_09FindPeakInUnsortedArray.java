package gfgalgo.binarysearch;

public class Prob_09FindPeakInUnsortedArray {

    /*

    A peak element is an element whose neighbors have value smaller than that of the element.


    Peak element is greater than both left and right element
    if the middle is lesser than left then assumption is that atleast one peak element will be there in the left
    if the middle is higher than left then assumption is that atleast one peak element will be there in the right

     */


        static int peak(int arr[])
        {
            int low = 0, high = arr.length - 1;

          // Continue the search until the low pointer is less than or equal to the high pointer
            while(low <= high)
            {
                int mid = (low + high) / 2;
//                System.out.println(mid);

                // Check if the middle element is a peak element
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
