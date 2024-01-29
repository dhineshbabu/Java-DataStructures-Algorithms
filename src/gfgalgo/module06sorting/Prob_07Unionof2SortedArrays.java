package gfgalgo.module06sorting;

public class Prob_07Unionof2SortedArrays {
    /*
    idea is to use the modified merge function
     */

    /**
     * Prints the union of two sorted arrays in a sorted order.
     *
     * @param a the first sorted array
     * @param b the second sorted array
     */
    public static void unionArrays(int[] a, int[] b) {
        // Initialize variables for array indices and lengths
        int i = 0, j = 0;
        int m = a.length, n = b.length;

        // Iterate through both arrays
        while (i < m && j < n) {
            // Skip duplicates in the first array
            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }

            // Skip duplicates in the second array
            if (j > 0 && b[j - 1] == b[j]) {
                j++;
                continue;
            }

            // Compare elements and print the smaller one
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                // Elements are equal, print either one and move both pointers
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

        // Print the remaining elements in the first array
        while (i < m) {
            if (i == 0 || a[i] != a[i - 1]) {
                System.out.print(a[i] + " ");
            }
            i++;
        }

        // Print the remaining elements in the second array
        while (j < n) {
            if (j == 0 || b[j] != b[j - 1]) {
                System.out.print(b[j] + " ");
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {10, 30, 30, 60};
        unionArrays(a, b);
    }
}
