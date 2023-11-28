package gfgalgo.sorting;

public class Prob_09Partition_Lamuto {
    /*
    consider pivot as the final element in the array
    l=0
    h=len-1
    i = -1 (smaller element window)
    whenever there is an element smaller than pivot then add it to the end of amll element window and extend the window size

     */
    static int iPartition(int[] arr, int l, int h){
        int i = l-1; // starting of minimum window. before the first element of the array
        int pivot = arr[h]; // pivot will be last element of the array

        // loop thruogh the array until <=h-1
        for(int j=l; j<=h-1; j++) {
            if(arr[j] < pivot) {
                // then increment the minimum values window that is i is pointing
                i++;
                //swap the element with the element at ith position
                // this is how the minimum window size willg row
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        // finally swap the pivot with i+1 index
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1; // returns the pivot index
    }

    public static void main (String[] args)
    {
        int arr[] = new int[]{10,80,30,90,40,50,70};

        int n = arr.length;
        iPartition(arr,0,n-1);

        for(int x: arr)
            System.out.print(x+" ");

    }
}
