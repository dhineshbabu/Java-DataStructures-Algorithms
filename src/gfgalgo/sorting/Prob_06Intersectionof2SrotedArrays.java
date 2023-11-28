package gfgalgo.sorting;

public class Prob_06Intersectionof2SrotedArrays {
    /*
    Remove duplicates
    use the modified merge function

     */

    public static void mergeArrays(int[] a, int[] b) {

        // initiate both i and j variables
        int i=0, j=0;
        int m = a.length,  n = b.length;

        while(i<m && j<n) {
            // to avoid duplicated
            if(i>0 && a[i] == a[i-1]) {
                // continue the loop
                i++;
                continue;
            }
            if(a[i] < b[j]) { i++; }
            else if(a[i] > b[j]) {j++;}
            else {
                System.out.print(a[i]+" ");
                i++;
                j++;
            }

        }



    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {10, 30 , 60};

        mergeArrays(a, b);
    }
}
