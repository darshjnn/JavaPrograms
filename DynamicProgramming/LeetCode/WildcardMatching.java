/*
44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with
support for '?' and '*' where:
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

*/

package DynamicProgramming.LeetCode;

public class WildcardMatching {
	// Normal Zindagi: Time = O(n * m)
	public static boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		// Pattern p = ""
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = false;
		}

		// String s = ""
		for (int j = 1; j < m + 1; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s.charAt(i - 1) == s.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}

	// Mentos Zindagi: Optimised Approach 
	public static boolean isMatchOpt(String s, String p) {
		int n = s.length();
		int m = p.length();

		int i = 0, j = 0;
		int matching = 0, checkpoint = -1;

		while (i < n) {
			if (j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				++i;
				++j;
			} else if (j < m && p.charAt(j) == '*') {
				checkpoint = j;
				matching = i;
				++j;
			} else if (checkpoint != -1) {
				j = checkpoint + 1;
				i = ++matching;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		
		return j == m;
	}

	public static void main(String[] args) {
		String s = "aabbab";
		String p = "**?*a";

		System.out.println(isMatch(s, p));
		System.out.println(isMatchOpt(s, p));
	}
}
