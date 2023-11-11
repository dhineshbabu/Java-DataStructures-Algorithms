package gfgalgo.sorting;

public class Prob_Merge2SortedArrays {
    /* use 2 pointer approach
    pointer i for arr1 and j for arr2
    traverse both arrays simultaneously and print the smallest items
    time : O(m+n)
     */
    public static void mergeArrays(int[] a, int[] b) {

        // initiate both i and j variables
        int i=0, j=0;
        int m = a.length,  n = b.length;

        while(i<m && j<n) {
            if(a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j]+ " ");
                j++;
            }
        }

        // print the rest of items in the l;arger array
        while(i <m){
            System.out.print(a[i] + " ");
            i++;
        }

        while(j < n){
            System.out.print(b[j] + " ");
            j++;
        }

    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {5, 50 , 60};

        mergeArrays(a, b);
    }
}
