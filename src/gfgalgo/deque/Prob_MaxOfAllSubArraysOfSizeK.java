package gfgalgo.deque;

import java.util.Deque;
import java.util.LinkedList;

public class Prob_MaxOfAllSubArraysOfSizeK {
    /*
    idea is to use deque

     */

    static void printMax(int[] arr, int k){
        int n = arr.length;

        Deque<Integer> dq = new LinkedList<>();

        // add the first window items
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i); // only storing the index in deque
        }

        // process the rest of the elements after first window
        for(int i=k; i<n; i++) {
            //print the max in first window which will bne at the first position
            System.out.print(arr[dq.peek()]+ " ");
            while(!dq.isEmpty() && dq.peek() <= i-k){
                // remove the previous window index if any
                dq.removeFirst();
            }

            // do the comparison again with element
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.print(arr[dq.peekLast()]+ " ");
    }

}
