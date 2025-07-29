/*
1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence.
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters
(can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

*/

package DynamicProgramming.LeetCode;

import java.util.Arrays;

public class LongestSubsequence {
	// Recursion
	public static int recLCS(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return recLCS(s1, s2, (n - 1), (m - 1)) + 1;
		}

		return Math.max(recLCS(s1, s2, (n - 1), m), recLCS(s1, s2, n, m - 1));
	}

	// Memoization
	public static int lcsMem(String s1, String s2, int n, int m, int[][] dp) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return dp[n][m] = lcsMem(s1, s2, (n - 1), (m - 1), dp) + 1;
		}

		return dp[n][m] = Math.max(lcsMem(s1, s2, (n - 1), m, dp), lcsMem(s1, s2, n, (m - 1), dp));
	}

	// Tabulation
	public static int lcsTab(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		if (n == 0 || m == 0) {
			return 0;
		}

		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[n][m];
	}

	public static void main(String[] args) {
		String s1 = "abcdge";
		String s2 = "abedg";
		int n = s1.length();
		int m = s2.length();

		System.out.println(recLCS(s1, s2, n, m));

		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(lcsMem(s1, s2, n, m, dp));

		System.out.println(lcsTab(s1, s2));
	}
}
