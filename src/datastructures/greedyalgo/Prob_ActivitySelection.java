package datastructures.greedyalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Activity {
     int start, finish;
     Activity(int s, int f){
         start = s;
         finish = f;
     }

}

// create a MyCmp class for sorting
class MyCmp implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2){
        return a1.finish - a2.finish;
    }
}

public class Prob_ActivitySelection {
    /*
    steps
        1. sort the activities according to the finish time
        2. Initialize solution as first activity
        3. Do the following for remaining
            a. if the current activity overlaps with the last picked activity in the soln, then ignore
            b. Else add the current activity to the solution
     */

    static int maxActivity(Activity[] arr){
        // sort the array according to finish time
        Arrays.sort(arr, new MyCmp());
        int res = 1;
        int prev = 0;

        // check for the comparison and overlap
        for (int curr = 1; curr < arr.length; curr++) {
            if(arr[curr].start >= arr[prev].finish) {
                res++;
                prev = res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Activity[] arr = {
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)
        };

        System.out.println(maxActivity(arr));
    }

}
