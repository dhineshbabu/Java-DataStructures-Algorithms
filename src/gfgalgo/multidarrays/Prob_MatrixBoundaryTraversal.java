package gfgalgo.multidarrays;

public class Prob_MatrixBoundaryTraversal {
    static void boundaryTraveral(int mat[][]){
        // get row and column count
        int R = mat.length;
        int C = mat[0].length;

        //if only 1 row is there
        if(R == 1)
        {
            for(int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
        }
        // if only 1 column is there
        else if(C == 1)
        {
            for(int i = 0; i < R; i++)
                System.out.print(mat[i][0] + " ");
        }
        else
        {
            for(int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
            for(int i = 1; i < R; i++)
                System.out.print(mat[i][C - 1] + " ");
            for(int i = C - 2; i >= 0; i--)
                System.out.print(mat[R - 1][i] + " ");
            for(int i = R - 2; i >= 1; i--)
                System.out.print(mat[i][0] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        boundaryTraveral(a);
    }
}
