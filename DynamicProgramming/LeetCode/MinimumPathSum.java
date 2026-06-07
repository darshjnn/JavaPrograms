/*
64. Minimum Path Sum

Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

*/

package DynamicProgramming.LeetCode;

public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		if (n == 0) {
			return 0;
		}

		// dp array to store the minimum path sum for the current row
		int[] dp = new int[n];

		// Initialize the first cell
		dp[0] = grid[0][0];
		
		// Initialize the rest of the first row
		for (int c = 1; c < n; c++) {
			dp[c] = dp[c - 1] + grid[0][c];
		}
		
		// Fill the DP array for the remaining rows
		for (int r = 1; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (c == 0) {
					// First column can only come from the top
					dp[c] += grid[r][c];
				} else {
					// Other cells can come from top (dp[c]) or left (dp[c-1])
					dp[c] = Math.min(dp[c], dp[c - 1]) + grid[r][c];
				}
			}
		}
		
		
		return dp[n - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		
		System.out.println(minPathSum(grid));
	}
}
