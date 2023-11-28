package gfgalgo.sorting;

public class Prob_12FindKthSmallestUnsortedArray {

    // using lamuto partition. Initial pivot will be the final element
    // then check with pivot position
    // if p == k-1 the return arr[p]
    // else if p > k-1 the high=p-1
    // els if p < k-1 then low=p+1
    static int partition(int arr[], int l, int h)
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

    static int kthSmallest(int arr[],int k){
        int n= arr.length;
        // set the low and high
        int low = 0, high = n-1;
        while(low <= high) {
            // get the pivot point
            int p = partition(arr, low, high);
            if(p == k-1) {
                return p;
            } else if(p > k-1) {
                high = p-1;
            } else {
                low = p + 1;
            }
        }
        return -1;

    }


    public static void main (String[] args)
    {
        int arr[] = new int[]{10,4,5,8,11,6,26};

        int n = arr.length;int k=5;
        int index=kthSmallest(arr,k);

        System.out.print(arr[index]);

    }
}
