/*
Job Sequencing

Given an array of jobs, where every job has a deadline and profit if the job is finished
before the deadline. It is also given that every job takes a single unit of time, so the
minimum possible deadline for any job is 1. Maximize the total profit if only one job can
be scheduled at a time.

Job A = 4, 20
Job B = 1, 10
Job C = 1, 40
Job D = 1, 30

Ans: C, A

*/

package GreedyAlgo;

import java.util.ArrayList;

public class JobSequencing {
    static class Job {
        int index, deadline, profit;

        Job(int index, int deadline, int profit) {
            this.index = index;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int jobSequence(int[][] jobs) {
        ArrayList<Job> jobArray = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            jobArray.add(new Job(i, jobs[i][0], jobs[i][1]));
        }

        // Sorting Jobs based on their Profit in Descending order.
        jobArray.sort((a, b) -> (b.profit - a.profit));

        int time = 0, profit = 0;
        ArrayList<Integer> sequence = new ArrayList<>();
        for (Job job : jobArray) {
            if (job.deadline > time) {
                ++time;
                profit += job.profit;
                sequence.add(job.index);
            }
        }

        System.out.println("Job Sequence: " + sequence);

        return profit;
    }

    public static void main(String[] args) {
        int[][] jobs = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        System.out.println("Profit: " + jobSequence(jobs));
    }
}
