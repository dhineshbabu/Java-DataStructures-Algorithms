package gfgalgo.sorting;

public class QuickSort {
    /*
    Divide and Conquer
    Worst case time: O(n^2)
    But it is faster because
        in-place
        cache friendly
        avg. case is O(nlogn)
        tail recursive
    Partition is key function(Naive, Lomuto, Hoare)
     */

    // using lumato Partition
    static int iPartition(int arr[], int l, int h)
    {
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }

    // using hoares partition
    static int iPartitionHoares(int[] arr, int l, int h) {
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



    static void qSort(int[] arr, int l, int h) {
        if(l<h) {
            int p = iPartition(arr, l ,h);
            qSort(arr, l, p-1); // before partition
            qSort(arr, p+1, h); // after partition
        }
    }

    static void qSortHoares(int[] arr, int l, int h) {
        if(l<h) {
            int p = iPartitionHoares(arr, l ,h);
            qSort(arr, l, p); // incldes pivot
            qSort(arr, p+1, h); // after partition
        }
    }


    public static void main (String[] args)
    {
        int arr[] = new int[]{8,4,7,9,3,10,5};

        int n = arr.length;
        qSort(arr,0,n-1);

        for(int x: arr)
            System.out.print(x+" ");

        //.hoares
        int arr1[] = new int[]{8,4,7,9,3,10,5};

        int n1 = arr1.length;
        qSortHoares(arr1,0,n-1);

        System.out.println();
        for(int x: arr1)
            System.out.print(x+" ");

    }


}
