package gfgalgo.multidarrays;

public class Prob_01Basic_3DArray {
    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6}
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+ " ");
            }

        }
    }
}
