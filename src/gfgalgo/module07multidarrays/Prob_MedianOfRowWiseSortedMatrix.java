package gfgalgo.module07multidarrays;

import java.util.*;

public class Prob_MedianOfRowWiseSortedMatrix {

    static public int matMed(int mat[][], int r, int c) {
        // Initialize min and max values
        int min = mat[0][0], max = mat[0][c - 1];

        // Find the minimum and maximum values in the first column and last column
        for (int i = 1; i < r; i++) {
            if (mat[i][0] < min)
                min = mat[i][0];

            if (mat[i][c - 1] > max)
                max = mat[i][c - 1];
        }

        // Calculate the position of the median element
        int medPos = (r * c + 1) / 2;

        // Binary search for the median value
        while (min < max) {
            int mid = (min + max) / 2;
            int midPos = 0;
            int pos = 0;

            // Search for the position of mid in each row using binary search
            for (int i = 0; i < r; ++i) {
                // Use Arrays.binarySearch to find the position of mid in the row
                pos = Arrays.binarySearch(mat[i], mid);

                // If mid is not found, adjust the position to the insertion point
                if (pos < 0)
                    pos = Math.abs(pos) - 1;
                else {
                    // If mid is found, find the last occurrence of mid in the row
                    while (pos < mat[i].length && mat[i][pos] == mid)
                        pos += 1;
                }

                // Accumulate the positions
                midPos = midPos + pos;
            }

            // Update min or max based on the accumulated position
            if (midPos < medPos)
                min = mid + 1;
            else
                max = mid;
        }

        // Return the median value
        return min;
    }

    public static void main(String[] args) {
        // Test data
        int r = 3, c = 5;
        int m[][] = {{5, 10, 20, 30, 40}, {1, 2, 3, 4, 6}, {11, 13, 15, 17, 19}};

        // Call matMed function and print the result
        System.out.println("Median is " + matMed(m, r, c));
    }


}
