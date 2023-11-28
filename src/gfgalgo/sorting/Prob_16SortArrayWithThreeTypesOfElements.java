package gfgalgo.sorting;

public class Prob_16SortArrayWithThreeTypesOfElements {
    /*
    Dutch National Flag Problem
     */
    static void sort(int[] arr) {
        int start = 0, mid = 0, end=arr.length-1;

        while(mid <= end) {
            if(arr[mid] == 0) {
                int temp=arr[start];
                arr[start]=arr[mid];
                arr[mid]=temp;

                start++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else if(arr[mid] == 2) {
                int temp=arr[end];
                arr[end]=arr[mid];
                arr[mid]=temp;

                end--;
            }
        }
    }

    public static void main (String[] args)
    {
        int arr[] = new int[]{0,1,1,2,0,1,1,2};

        int n = arr.length;

        sort(arr);

        for(int x:arr)
            System.out.print(x+" ");

    }
}
