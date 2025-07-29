/*
Target Subset Sum

Given an array arr[] of non-negative integers and a value sum, the task is to check if there is
a subset of the given array whose sum is equal to the given sum.

Examples 1:
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Examples 2:
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: False
Explanation: There is no subset that add up to 30.

*/

package DynamicProgramming;

import java.util.Arrays;

public class TargetSubsetSum {
	public static boolean subsetSum(int[] nums, int target) {
		int n = nums.length;
		boolean[][] dp = new boolean[target + 1][n + 1];
		
		Arrays.fill(dp[0], true);
		
		for (int i = 1; i < target + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int curr = nums[j - 1];
				if (curr <= i && dp[i - curr][j - 1]) {
					// Include
					dp[i][j] = true;
				} else if (dp[i][j - 1]) {
					// Exclude
					dp[i][j] = true;
				}
			}
		}
		
		return dp[target][n];
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 2, 7, 1, 3};
		int target = 10;
		System.out.println(subsetSum(nums, target));
	}
}
