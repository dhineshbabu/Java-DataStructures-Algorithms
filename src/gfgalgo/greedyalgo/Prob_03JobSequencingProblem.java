package gfgalgo.greedyalgo;

import java.util.Arrays;
import java.util.Comparator;

// create a job class
class Job {
    char id;
    int deadLine;
    int profit;

    Job(char id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }
}

public class Prob_03JobSequencingProblem {
    /*
    sort the jobs in decreasing order
    initialize the result as first job in the sorted list and assign the latest possible job
    do the following for the remaining (n-1) jobs
    * if the job cannot be added ignore the job
    * else add it to the latest possible slot
     */

    public static void printSeq(Job[] jobs){
        // sort the jobs array with decreasing order according to profit
        Arrays.sort(jobs, Comparator.comparingInt((Job j) -> j.profit).reversed());

        for(Job job: jobs) {
            System.out.println(job.id+" " +job.profit+" " +job.deadLine);
        }

        // Maintain 3 variables
        int n = jobs.length;
        int[] result = new int[n];
        boolean[] slot = new boolean[n];

        // intialize all slots to be free
        Arrays.fill(slot, false);


        // Iterate through all the jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (Note: We start from the last possible slot)
            for (int j = Math.min(n, jobs[i].deadLine) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = i;  // Add the job to the result
                    slot[j] = true; // Mark this slot as occupied
                    break;
                }
            }
        }

        // Print the result
        System.out.println("Job Sequence:");

        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                System.out.println("Job " + jobs[result[i]].id + " - Deadline: " + jobs[result[i]].deadLine + ", Profit: " + jobs[result[i]].profit);
            }
        }


    }
    // main class
    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        printSeq(jobs);
    }

}
