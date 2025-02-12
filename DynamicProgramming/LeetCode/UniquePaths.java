/*
62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at top-left corner
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner
(i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can
take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 10^9.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right
			corner:
				1. Right -> Down -> Down
				2. Down -> Down -> Right
				3. Down -> Right -> Down

*/

package DynamicProgramming.LeetCode;

public class UniquePaths {
	// Aam Zindagi: Using Recursion & Backtracking
	// Time Complexity: O(2^(n + m))
	// Space Complexity: O(m + n)
	public static int countWays(int i, int j, int m, int n) {
		if (i == (m - 1) && j == (n - 1)) {
			return 1;
		} else if (i >= m || j >= n) {
			return 0;
		}

		int right = countWays(i, j + 1, m, n);
		int down = countWays(i + 1, j, m, n);

		return right + down;
	}

	public static int uniquePathsRecur(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		return countWays(0, 0, m, n);
	}

	// Mentos Zindagi: Using Permutation
	// Time Complexity: O(n + m)
	public static double multiplyRange(double n, double range) {
		if (n < range) {
			return 1;
		}

		return n * multiplyRange(n - 1, range);
	}

	public static int uniquePathsPermute(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		/*
		Permutation of (x + y) objects, where x & y are of similar kind:
		(x + y)!/(x! y!)
		*/

		int range = Math.max(n - 1, m - 1);
		double total = multiplyRange(m - 1 + n - 1, range + 1);

		if (range == (n - 1)) {
			double right = multiplyRange(m - 1, 1);
			return (int) (total / right);
		} else {
			double down = multiplyRange(n - 1, 1);
			return (int) (total / down);
		}
	}

	// Ultra Mentos Zindagi: Dynamic Programming
	// Time Complexity: O(n * m)
	// Space Complexity: O(n * m)
	// Approach 1: Tabulation
	public static int uniquePathsDPTab(int m, int n) {
		if (m == 1 && n == 1) {
			return 1;
		}

		int[][] dp = new int[m + 1][n + 1];
		dp[m - 1][n - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
			}
		}

		return dp[0][0];
	}

	// Approach 2: Recursion + Memoization
	public static int countWays(int i, int j, int[][] dp) {
		if (i < 0 || j < 0) {
			return 0;
		}

		if (i == 0 && j == 0) {
			return 1;
		}

		if (dp[i][j] == 0) {
			return dp[i][j] = countWays(i - 1, j, dp) + countWays(i, j - 1, dp);
		}

		return dp[i][j];
	}

	public static int uniquePathsDPRec(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] dp = new int[m][n];

		return countWays(m - 1, n - 1, dp);
	}

	// Ultra Pro Mentos Zindagi: DP with Space Optimized
	// If Previous row and Previous column are required, space can be Optimized.
	// Time Complexity: O(n * m)
	// Space Complexity: O(n)
	public static int uniquePathsDPOpt(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		int[] prev = new int[n];

		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					temp[j] = 1;
				} else {
					int up = 0, left = 0;
					if (i > 0) {
						up = prev[j];
					}
					if (j > 0) {
						left = temp[j - 1];
					}
					temp[j] = up + left;
				}
			}
			prev = temp;
		}

		return prev[n - 1];
	}

	public static void main(String[] args) {
		int m = 10;
		int n = 10;

		System.out.println(uniquePathsRecur(m, n));
		System.out.println(uniquePathsPermute(m, n));
		System.out.println(uniquePathsDPTab(m, n));
		System.out.println(uniquePathsDPRec(m, n));
		System.out.println(uniquePathsDPOpt(m, n));
	}
}