package gfgalgo.module19backtracking;

public class Prob_04SudokuProblem {

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if 'num' is already present in the current row
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        // Check if 'num' is already present in the current column
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // Check if 'num' is already present in the 3x3 box containing the cell at position (row, col)
        int sqrt = (int) Math.sqrt(board.length); // Calculate the square root of the board size to determine the box size
        int boxRowStart = row - row % sqrt; // Identify the starting row index of the 3x3 box
        int boxColStart = col - col % sqrt; // Identify the starting column index of the 3x3 box

        // Iterate over the cells within the 3x3 box
        for (int boxRow = boxRowStart; boxRow < boxRowStart + sqrt; boxRow++) {
            for (int boxCol = boxColStart; boxCol < boxColStart + sqrt; boxCol++) {
                // Check if 'num' is already present in the current cell of the 3x3 box
                if (board[boxRow][boxCol] == num) {
                    // If 'num' is found in the current box, it's not safe to place 'num' in the cell at position (row, col)
                    return false;
                }
            }
        }

        // If 'num' is not present in the current row, column, or box, it's safe to place it.
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find an empty cell (cell with value 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If there are no empty cells, the Sudoku is solved
        if (isEmpty) {
            return true;
        }

        // Try placing numbers from 1 to n in the empty cell
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                // If it's safe to place 'num', assign it to the cell
                board[row][col] = num;

                // Recursively try to solve the Sudoku with the updated board
                if (solveSudoku(board, n)) {
                    // If a solution is found, return true
                    return true;
                } else {
                    // If placing 'num' doesn't lead to a solution, backtrack and try the next number
                    board[row][col] = 0;
                }
            }
        }

        // If no number can be placed in the current cell, backtrack
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
//
//            if ((r + 1) % (int) Math.sqrt(N) == 0) {
//                System.out.print("");
//            }
        }
    }

    public static void main(String args[]) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int N = board.length;

        if (solveSudoku(board, N)) {
            print(board, N);
        } else {
            System.out.println("No solution");
        }
    }
}
