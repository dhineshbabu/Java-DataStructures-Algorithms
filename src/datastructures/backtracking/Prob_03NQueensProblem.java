package datastructures.backtracking;

public class Prob_03NQueensProblem {

    // initialize common
    static final int N = 4;

    static int board[][] = { { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } };

    static boolean isSafe(int row, int col) {
        int i, j;

        // check if the current row contains any queen
        for (i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        // check if upper diagonal contains any queen
        for (i = row, j=col; i >= 0 &&  j>=0 ; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // check if lower diagonals contain quuen
        for(i=row, j=col; j>=0 && i<N; i++, j--){
            if(board[i][j] == 1) {
                return false;
            }
        }

        // if none of them are returning false then this is the safe row
        return true;
    }

    // main recursion function
    static boolean solveRec(int col) {
        // base cases
        if(col == N) return true;

        for (int i = 0; i < N; i++) {
            // check if it is safe then proceed
            if(isSafe(i, col)) {
                board[i][col] = 1;

                // check for the next colum
                if(solveRec(col+1) == true) {
                    return true;
                }

                // if not then backtrack and set to 0

                board[i][col] = 0;
            }
        }

        return false;
    }

    public static boolean solve() {
        if(solveRec(0) ==  false) {
            System.out.println("Solution does not exist");
            return false;
        }

        // if not the print the target board
        printSolution(board);
        return true;
    }

    static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    // trigger method
    public static void main(String[] args) {
        solve();
    }
}
