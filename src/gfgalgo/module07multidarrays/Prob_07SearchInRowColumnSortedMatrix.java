package gfgalgo.module07multidarrays;

public class Prob_07SearchInRowColumnSortedMatrix {
    /*
    1. Begin from the top right corner element
    2. if x is same, print the position
    3. if x is smaller , then move left 1 position
    4. if x is greater then move down 1 position
     */

    static int R = 4, C = 4;

    static void search(int mat[][], int x) {
        // Start from the top-right corner of the matrix
        int i = 0, j = mat[0].length - 1;

        // Traverse the matrix
        while (i < mat.length && j >= 0) {
            // If the current element is equal to the target value x
            if (mat[i][j] == x) {
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            }
            // If the current element is greater than x, move left in the same row
            else if (mat[i][j] > x) {
                j--;
            }
            // If the current element is less than x, move down in the same column
            else {
                i++;
            }
        }

        // If the loop completes without finding the target value
        System.out.println("Not Found");
    }

    public static void main(String args[]) {
        int arr[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 35, 45},
                {32, 33, 39, 50}};
        int x = 29;

        search(arr, x);


    }
}
