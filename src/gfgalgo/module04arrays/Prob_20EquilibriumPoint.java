package gfgalgo.module04arrays;

public class Prob_20EquilibriumPoint {
    /*
    equilibrium point in an arry: element for which the sum of both left and sum of right will be the same

    idea:
    compute prefix sum and suffix sum values
    at any point if leftSUm == rightSum then we will have the equilibrium point
     */
    static boolean isEquilibrium(int[] arr) {
        int n = arr.length;
        int rs = 0;

        // calcualte the right sum as total sum
        for (int i = 0; i < n; i++) {
            rs += arr[i];
        }

        int ls = 0;

        // for each element check if the left and right sum are same
        for (int i = 0; i < n; i++) {
            rs -= arr[i]; // rightsum is rs - currentelement
            // check
            if (ls == rs) return true;

            // calculate the ls for the next element
            ls += arr[i];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEquilibrium(new int[]{3, 4, 8, -9, 9, 7}));
    }
}
