package datastructures.twodarrays;

import java.util.Arrays;

public class TwoDArrayDemo {
    public static void main(String[] args) {

        // Traversing or Searching is O(m*n), other operations are O(1) mostly

        // declare
        int[][] int2DArray;

        // instantiate
        int2DArray = new int[2][2];

        // initialize
        int2DArray[0][0] = 1;
        int2DArray[0][1] = 2;
        int2DArray[1][0] = 1;
        int2DArray[1][1] = 1;

        System.out.println(Arrays.toString(int2DArray)); //[[I@4617c264, [I@36baf30c]
        System.out.println(Arrays.deepToString(int2DArray));

        // String 2D Array
        System.out.println("*** string 2D array ***");
        String[][] s2DArray = {{"a", "b"}, {"c", "d"}};
        System.out.println(Arrays.deepToString(s2DArray));
    }
}
