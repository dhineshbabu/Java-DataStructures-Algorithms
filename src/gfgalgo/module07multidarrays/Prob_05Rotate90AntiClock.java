package gfgalgo.module07multidarrays;

public class Prob_05Rotate90AntiClock {

    /*
    The idea is to do the following operations
    1. Find transpose of matrix
    2. reverse the individual columns
        For reverse keep low - 0, high - n-1
        while(low <high)
        swap(arr[low][i], arr[high][i]

     */
    static int n = 4;

    static void swap1(int mat[][], int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void swap2(int low, int high, int i, int mat[][]) {
        int temp = mat[low][i];
        mat[low][i] = mat[high][i];
        mat[high][i] = temp;
    }

    static void rotate90(int mat[][]) {

        // Transpose the matrix
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                swap1(mat, i, j);

        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                swap2(low, high, i, mat);
                low++;
                high--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        rotate90(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}