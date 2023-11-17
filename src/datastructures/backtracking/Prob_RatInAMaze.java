package datastructures.backtracking;

public class Prob_RatInAMaze {
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

    static boolean isSafe(int[][]  maze, int i, int j) {
        return (i<N && j<N && maze[i][j]==1);
    }

    // this is the trigger function
    static boolean solveMaze(int[][] maze) {
       // initiate the target array
        int[][] soln = new int[N][N];

        if(solveMazeRec(maze, 0, 0, soln) == false) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(soln);
        return true;
    }

    static boolean solveMazeRec(int[][] maze, int i, int j, int[][] soln ){
        // base case
        if(i == N-1 && j== N-1 & maze[i][j] == 1) {
            soln[i][j] = 1;
            return true;
        }

        // chekc safe and backtrack
        if(isSafe(maze, i, j) == true) {
            soln[i][j] =1;

            if(solveMazeRec(maze,i+1, j, soln) == true) {
                return true;
            }

            if(solveMazeRec(maze,i, j+1, soln) == true) {
                return true;
            }

            // if not true then set soln position to 0. Back track
            soln[i][j] = 0;
        }
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
