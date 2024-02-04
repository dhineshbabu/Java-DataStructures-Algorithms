package gfgalgo.module16heap;

import java.util.PriorityQueue;


public class Prob_03_BuyingMaxItemsWithGivenSum {
    /*
    This video discusses the problem of buying the maximum items with a given sum.
     */

    public static void main(String args[]) {
        int n = 5;
        int cost[] = new int[]{1, 12, 5, 111, 200};
        int sum = 10;

        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int res = 0;

        // Insert all elements into the min-heap
        for (int i = 0; i < n; i++)
            pq.add(cost[i]);

        // Process elements from the min-heap until the sum is less than or equal to 0
        for (int i = 0; i < n; i++) {
            // Check if the smallest cost from the min-heap is less than or equal to the remaining sum
            if (pq.peek() <= sum) {
                sum -= pq.poll(); // Subtract the cost from the sum
                res++; // Increment the result counter
            } else {
                break; // Break the loop if the cost is greater than the remaining sum
            }
        }

        // Print the result
        System.out.print(res);
    }
}
