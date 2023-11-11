package gfgalgo.sorting;

public class Partition_Hoare {
    /*
    here we consider first element as pivot element
    pivot = arr[l]
    i = l-1
    j=h+1

    2 pointer approach

     */

    public static int iPartition(int[] arr, int l, int h) {
        int pivot = arr[l]; // start of the array
        int i = l-1;
        int j = h+1;

        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);

            do {
                j--;
            }while(arr[j]> pivot);

            // check if i crossed j
            if(i >=j) return j;

            // else swap j with i
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

    }

    public static void main (String[] args)
    {
        int arr[] = new int[]{5,3,8,4,2,7,1,10};

        int n = arr.length;
        iPartition(arr,0,n-1);

        for(int x: arr)
            System.out.print(x+" ");

    }
}
