package gfgalgo.sorting;

public class MergeSort {
    /*
    Divide and Conquer and Merge
    Stable Sort
    O(nlogn)
    Well suited for Linked list

    1. check if atleast 2 elements int he array
    2. find the mid point and recursively apply the mergesort for both the left and right half
    3. then merge the arrays

     */

    static void merge(int[] arr, int l, int mid, int r) {
        int m = mid-l+1;
        int n = r-mid;

        // fill the arrays
        int[] left = new int[m];
        int[] right = new int[n];

        for(int i=0;i<m;i++)
            left[i]=arr[i+l];
        for(int j=0;j<n;j++)
            right[j]=arr[mid+1+j];
        int i=0,j=0,k=l;
        while(i<m && j<n){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }
        while(i<m)
            arr[k++]=left[i++];
        while(j<n)
            arr[k++]=right[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        // split the array until l>r that is minimum 1 element
        if(l < r) {
            int mid = l + (r-l)/2;
            // call the merge sort for the left half
            mergeSort(arr, l, mid);
            // call the merge sort for the right half
            mergeSort(arr, mid+1, r);
            //merge the arrays as sorted after splitting
            merge(arr, l, mid, r);
        }
    }

    public static void main (String[] args)
    {
        int a[] = new int[]{10,5,30,15,7};
        int l=0,r=4;

        mergeSort(a,l,r);
        for(int x: a)
            System.out.print(x+" ");

    }

}
