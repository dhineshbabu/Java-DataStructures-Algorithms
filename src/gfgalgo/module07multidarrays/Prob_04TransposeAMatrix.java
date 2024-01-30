package gfgalgo.module07multidarrays;

public class Prob_04TransposeAMatrix {

    /*
    idea is to swap the upper diagonal elements with lower diagonal elements
    This means arr[i][j] is swapped with arr[j][i], considering the fact that, elements present on the main diagonal of the matrix remain at the same position, even after transpose.
    
    arr[0][0]
    arr[1][1]
    arr[2][2]
    arr[3][3] will be skipped as there is no change in the diagonal
     */

    static int n = 4;

    static void swap(int mat[][], int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void transpose(int mat[][]) {

        // Iterate over the upper triangular part of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap the elements at positions (i, j) and (j, i)
                swap(mat, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        transpose(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
