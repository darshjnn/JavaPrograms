/*
96. Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which
has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1

*/

/*
It can be solved using Catalan's Number concept.
*/

package DynamicProgramming.LeetCode;

public class CountBST {
	public static int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				int leftSubtree = dp[j];
				int rightSubtree = dp[i - j - 1];
				dp[i] += leftSubtree * rightSubtree;
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
	}
}
