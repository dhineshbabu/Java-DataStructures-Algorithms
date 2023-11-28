package gfgalgo.sorting;

public class Prob_07Unionof2SortedArrays {
    /*
    idea is to use the modified merge function
     */

    public static void unionArrays(int[] a, int[] b) {

        // initiate both i and j variables
        int i=0, j=0;
        int m = a.length,  n = b.length;

        while(i<m && j<n){
            if(i>0 && a[i-1]==a[i]){i++;continue;}
            if(j>0 && b[j-1]==b[j]){j++;continue;}
            if(a[i]<b[j]){System.out.print(a[i]+" ");i++;}
            else if(a[i]>b[j]){System.out.print(b[j]+" ");j++;}
            else{System.out.print(a[i]+" ");i++;j++;}
        }
        //print the rest of the elements

        while(i<m){if(i==0||a[i]!=a[i-1])System.out.print(a[i]+" ");i++;}
        while(j<n){if(j==0||b[j]!=b[j-1])System.out.print(b[j]+" ");j++;}
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {10, 30 , 60};
        unionArrays(a, b);
    }
}
