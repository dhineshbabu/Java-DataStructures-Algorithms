package gfgalgo.module06sorting;

import java.util.*;

public class Prob_18MergeOverlappingIntervals {
    /*
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

     */

    public int[][] merge(int[][] intervals) {
        // If there is only one interval, return the input as it is already merged
        if (intervals.length == 1) return intervals;

        // Sort the intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // List to store the merged intervals
        List<int[]> result = new ArrayList<>();

        // Initialize with the first interval
        int[] newInterval = intervals[0];
        result.add(newInterval);

        // Iterate through the sorted intervals and merge overlapping ones
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // If the current interval overlaps with the newInterval, update the end time of newInterval
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                // If the current interval doesn't overlap, add it as a new interval
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Convert the List to a 2D array and return the result
        return result.toArray(new int[result.size()][]);
    }
}
