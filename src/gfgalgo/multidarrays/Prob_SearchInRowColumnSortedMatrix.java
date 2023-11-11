package gfgalgo.multidarrays;

public class Prob_SearchInRowColumnSortedMatrix {
    /*
    1. Begin from the top right corner element
    2. if x is same, print the position
    3. if x is smaller , then move left 1 position
    4. if x is greater then move down 1 position
     */

    static int R = 4, C = 4;

    static void search(int mat[][], int x)
    {
        int i  = 0, j = C - 1;

        while(i < R && j >= 0)
        {
            if(mat[i][j] == x)
            {
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            }
            else if(mat[i][j] > x)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String args[])
    {
        int arr[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 35, 45},
                {32, 33, 39, 50}};
        int x = 29;

        search(arr, x);


    }
}
