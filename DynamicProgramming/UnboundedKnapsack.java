/*
Unbounded Knapsack

Given:
    1. A set of N items, each with: Value val[i] Weight wt[i].
    2. A knapsack with a maximum weight capacity W.

Determine the maximum value that can be achieved by selecting items such that:
    1. The total weight of selected items does not exceed W.
    2. Repetition of item is allowed.

*/

package DynamicProgramming;

public class UnboundedKnapsack {
	// Tabulation - O(n * W)
	public static int unboundedKnapsack(int[] wt, int[] val, int W, int n) {
		if (n <= 0 || W <= 0) {
			return 0;
		}
		
		int[][] dp = new int[n + 1][W + 1];
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) {
					// Include
					int include = val[i - 1] + dp[i][j - wt[i - 1]];
					
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
		
		System.out.println(unboundedKnapsack(weight, value, W, n));
	}
}
