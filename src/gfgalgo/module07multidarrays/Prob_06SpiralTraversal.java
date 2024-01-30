package gfgalgo.module07multidarrays;

public class Prob_06SpiralTraversal {
    /*
    idea is to use 4 variables top, left, right, bottom
    update them accordingly and print the values
     */
    static void printSpiral(int mat[][], int R, int C) {
        int top = 0, left = 0, bottom = R - 1, right = C - 1;

        // Traverse the matrix in a spiral order
        while (top <= bottom && left <= right) {
            // Print top row from left to right
            for (int i = left; i <= right; i++)
                System.out.print(mat[top][i] + " ");

            // Move to the next row
            top++;

            // Print rightmost column from top to bottom
            for (int i = top; i <= bottom; i++)
                System.out.print(mat[i][right] + " ");

            // Move to the next column
            right--;

            // Print bottom row from right to left, if there is a bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(mat[bottom][i] + " ");

                // Move to the next row
                bottom--;
            }

            // Print leftmost column from bottom to top, if there is a leftmost column
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(mat[i][left] + " ");

                // Move to the next column
                left++;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printSpiral(arr, 4, 4);


    }
}
