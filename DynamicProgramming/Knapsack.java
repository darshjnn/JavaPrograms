/*
0/1 Knapsack

Given:
    1. A set of N items, each with: Value val[i] Weight wt[i].
    2. A knapsack with a maximum weight capacity W.

Determine the maximum value that can be achieved by selecting items such that:
    1. The total weight of selected items does not exceed W.
    2. Each item can either be included (1) or excluded (0).
    
*/

package DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
	// Recursion - O(2^n)
	public static int knapsackRec(int[] wt, int[] val, int W, int n) {
		if (n <= 0 || W <= 0) {
			return 0;
		}
		
		if (wt[n - 1] <= W) {
			// Include
			int include = val[n - 1] + knapsackRec(wt, val, W - wt[n - 1], n - 1);
			
			// Exclude
			int exclude = knapsackRec(wt, val, W, n - 1);
			
			return Math.max(include, exclude);
		} else {
			// wt[n - 1] > W, therefore exclude
			return knapsackRec(wt, val, W, n - 1);
		}
	}
	
	// Recursion + Memoization - O(n * W)
	public static int knapsackMem(int[] wt, int[] val, int W, int n, int[][] dp) {
		if (n <= 0 || W <= 0) {
			return 0;
		}
		
		if (dp[n][W] != -1) {
			return dp[n][W];
		}
		
		if (wt[n - 1] <= W) {
			// Include
			int include = val[n - 1] + knapsackMem(wt, val, W - wt[n - 1], n - 1, dp);
			
			// Exclude
			int exclude = knapsackMem(wt, val, W, n - 1, dp);
			
			return dp[n][W] = Math.max(include, exclude);
		} else {
			// wt[n - 1] > W, therefore exclude
			return dp[n][W] = knapsackMem(wt, val, W, n - 1, dp);
		}
	}
	
	// Tabulation - O(n * W)
	public static int knapsackTab(int[] wt, int[] val, int W, int n) {
		if (n <= 0 || W <= 0) {
			return 0;
		}
		
		int[][] dp = new int[n + 1][W + 1];
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) {
					// Include
					int include = val[i - 1] + dp[i - 1][j - wt[i - 1]];
					
					// Exclude
					int exclude = dp[i - 1][j];
					
					dp[i][j] = Math.max(include, exclude);
				} else {
					// wt[i - 1] > j, therefore exclude
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[n][W];
	}
	
	public static void main(String[] args) {
		int[] weight = {2, 5, 1, 3, 4};
		int[] value = {15, 14, 10, 45, 30};
		int W = 7; // Capacity of Knapsack
		int n = weight.length; // Total items
		
		System.out.println(knapsackRec(weight, value, W, n));
		
		int[][] dp = new int[n + 1][W + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(knapsackMem(weight, value, W, n, dp));
		
		System.out.println(knapsackTab(weight, value, W, n));
	}
}
