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
import java.util.Arrays;

public class JobSequencing {
	public static int jobSequence(int[][] jobs) {
		ArrayList<Job> jobArray = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			jobArray.add(new Job(i, jobs[i][0], jobs[i][1]));
		}
		
		// Sorting Jobs based on their Profit in Descending order.
		jobArray.sort((a, b) -> (b.profit - a.profit));
		
		// Find the maximum deadline
		int deadline = 0;
		for (int[] job : jobs) {
			deadline = Math.max(deadline, job[0]);
		}
		
		// Maximise the profit
		int profit = 0;
		int[] slot = new int[deadline + 1];
		Arrays.fill(slot, -1);
		
		for (Job job : jobArray) {
			int index = job.deadline;
			// Find the slot for the job
			while (index > 0 && slot[index] != -1) {
				--index;
			}
			
			// No slot found, the job cannot be executed
			if (index < 0 || slot[index] != -1) {
				break;
			}
			
			// Else, assign the slot
			slot[index] = job.index;
			profit += job.profit;
		}
		
		System.out.println("Jobs: " + Arrays.toString(slot));
		
		return profit;
	}
	
	public static void main(String[] args) {
		int[][] jobs = {{4, 20}, {5, 60}, {6, 70}, {6, 65}, {4, 25}, {2, 80}, {2, 10}, {2, 22}};
		System.out.println("Profit: " + jobSequence(jobs));
	}
	
	static class Job {
		int index, deadline, profit;
		
		Job(int index, int deadline, int profit) {
			this.index = index;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
}
