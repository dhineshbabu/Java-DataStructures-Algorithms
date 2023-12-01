package datastructures.backtracking;

public class Prob_02RatInAMaze {
    /*
    Rat is allowed only in the below steps in a binary matrix
    (i, j+1) - right
    (i+1, j) - down

    Also in this we move write the possible path in a solution array
     */

    static int N;

    static void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print( " " + sol[i][j] + " ");
            System.out.println();
        }
    }

    // Helper function to check if the current cell is safe to move into
    static boolean isSafe(int[][]  maze, int i, int j) {
        return (i<N && j<N && maze[i][j]==1);
    }

    // this is the trigger function
    // Main function to solve the maze
    static boolean solveMaze(int[][] maze) {
        // Initialize the solution array
        int[][] soln = new int[N][N];

        // If the recursive solver returns false, print a message and return false
        if (solveMazeRec(maze, 0, 0, soln) == false) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(soln);
        return true;
    }

    // Recursive function to solve the maze
    static boolean solveMazeRec(int[][] maze, int i, int j, int[][] soln) {
        // Base case: if we have reached the destination
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) {
            soln[i][j] = 1;
            return true;
        }

        // Check if the current cell is safe to move into
        if (isSafe(maze, i, j)) {
            // Mark the current cell as part of the solution path
            soln[i][j] = 1;

            // Try moving down and check if it leads to a solution
            if (solveMazeRec(maze, i + 1, j, soln)) {
                return true;
            }

            // Try moving right and check if it leads to a solution
            if (solveMazeRec(maze, i, j + 1, soln)) {
                return true;
            }

            // If neither of the above moves leads to a solution, backtrack
            soln[i][j] = 0;
        }

        // No solution found from this cell
        return false;
    }

    public static void main(String args[])
    {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        solveMaze(maze);
    }
}
