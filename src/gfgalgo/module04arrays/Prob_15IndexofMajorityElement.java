package gfgalgo.module04arrays;

public class Prob_15IndexofMajorityElement {
    /*
    Majority of an element is its presence for more than n/2 occurrences in an array

    // Moore’s Voting Algorithm
       // if the majority of element is presented then it will be atleast in 1 consecutive position ( more than n/2) in an array

    // phase 1:
        for loop - identify the candidate
    // phase 2:
        for loop - check if the candidate is actually a majority
     */
    public static int majorityElementIndex(int[] arr) {
        int res = 0, count = 1;
        int n = arr.length;

        // first for loop
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) count++;
            else count--;

            // if count is 0 then there is no consecutive element then reset and repeat
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // now the candiate index stored in res
        // reset the count to 0 for the second loop
        count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }
        if (count <= (n / 2))
            res = -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementIndex(new int[]{8, 8, 8, 5, 6, 8, 6}));
    }

}
