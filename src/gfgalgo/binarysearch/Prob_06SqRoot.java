package gfgalgo.binarysearch;

public class Prob_06SqRoot {

    /*

    In this problem, we are presented with a number, and our objective is to utilize binary search to
    determine the floor value of its square root in logarithmic complexity.

    idea is to check if the square(middle) > x then move to left or move to right
     */
    public static int sq(int x) {
        // get the input number


        // set the pointers
        int low=1, high=x, ans=-1;

        while(low <= high) {
            int mid = (low+high) / 2;

            int mSq = mid * mid;

            if(mSq == x) {
               return mid;
            } else if(mSq > x) {
                high = mid-1;
            } else {
                low=mid+1;
                ans = mid;
            }
        }

       return ans;
    }

    public static void main(String args[])
    {

        System.out.println(sq(10));

    }

}

