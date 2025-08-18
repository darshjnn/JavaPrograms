/*
Matrix Chain Multiplication

Given the dimension of a sequence of matrices in an array arr[], where the dimension of the
ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these
matrices together such that the total number of element multiplications is minimum.

When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and
the number of multiplications performed is m*n*p.

Example 1:
Input: arr[] = [2, 1, 3, 4]
Output: 20
Explanation: There are 3 matrices of dimensions 2x1, 1x3, and 3x4,
Let the input 3 matrices be M1, M2, and M3. There are two ways to multiply ((M1 x M2) x M3) and
(M1 x (M2 x M3)). The result of M1 x M2 is a 2 x 3 matrix and result of (M2 x M3) is a
1 x 4 matrix.
((M1 x M2) x M3) requires (2 x 1 x 3) + (2 x 3 x 4) = 30
(M1 x (M2 x M3)) requires (1 x 3 x 4) + (2 x 1 x 4) = 20
The minimum of these two is 20.

Example 2:
Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3. Let the input 4 matrices be
M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1M2)M3)M4.
The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30

Example 3:
Input: arr[] = [3, 4]
Output: 0
Explanation: As there is only one matrix so, there is no cost of multiplication.

*/

package DynamicProgramming;

import java.util.Arrays;

public class MatrixChain {
	// Recursion
	public static int minCostRec(int[] matrices, int start, int end) {
		if (start == end) {
			return 0; // Single Matrix
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for (int k = start; k <= end - 1; k++) {
			int cost1 = minCostRec(matrices, start, k); // M[start, ... , k]
			int cost2 = minCostRec(matrices, k + 1, end); // m[k + 1, ... , end]
			int cost3 = matrices[start - 1] * matrices[k] * matrices[end];
			
			int finalCost = cost1 + cost2 + cost3;
			minCost = Math.min(minCost, finalCost);
		}
		
		return minCost;
	}
	
	// Memoization: Time Complexity = O(n^2)
	public static int minCostMem(int[] matrices, int start, int end, int[][] dp) {
		if (start == end) {
			return 0;
		}
		
		if (dp[start][end] != -1) {
			return dp[start][end] = dp[start][end];
		}
		
		int minCost = Integer.MAX_VALUE;
		for (int k = start; k <= end - 1; k++) {
			int cost1 = minCostMem(matrices, start, k, dp);
			int cost2 = minCostMem(matrices, k + 1, end, dp);
			int cost3 = matrices[start - 1] * matrices[k] * matrices[end];
			int finalCost = cost1 + cost2 + cost3;
			
			minCost = Math.min(minCost, finalCost);
		}
		
		return dp[start][end] = minCost;
	}
	
	// Tabulation
	public static int minCostTab(int[] matrices) {
		int n = matrices.length;
		int[][] dp = new int[n][n];
		
		// Initialization
		for (int i = 0; i <= n - 1; i++) {
			dp[i][i] = 0;
		}
		
		for (int len = 2; len <= n - 1; len++) {
			for (int i = 1; i <= n - len; i++) {
				int j = i + len - 1; // Column
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int cost1 = dp[i][k];
					int cost2 = dp[k + 1][j];
					int cost3 = matrices[i - 1] * matrices[k] * matrices[j];
					int finalCost = cost1 + cost2 + cost3;
					
					dp[i][j] = Math.min(dp[i][j],  finalCost);
				}
			}
		}
		
		return dp[1][n - 1];
	}
	
	public static void main(String[] args) {
		int[] matrices = { 1, 2, 3, 4, 3 };
		int n = matrices.length;
		
		System.out.println(minCostRec(matrices, 1, n - 1));
		
		int[][] dp = new  int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(minCostMem(matrices, 1, n - 1, dp));
		
		System.out.println(minCostTab(matrices));
	}
}
