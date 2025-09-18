/*
45. The Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at
index 0.

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at index i, you can jump to any index (i + j) where:
	0 <= j <= nums[i] and
	i + j < n

Return the minimum number of jumps to reach index n - 1.
The test cases are generated such that you can reach index n - 1.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation:
The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

*/

package DynamicProgramming.LeetCode;

import java.util.Arrays;

public class JumpGameII {
	// Using DP
	public static int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		
		dp[n - 1] = 0;
		
		for (int i = n - 2; i >= 0; i--) {
			int minJumps = Integer.MAX_VALUE;
			for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
				if (dp[j] != -1 && dp[j] + 1 < minJumps) {
					minJumps = dp[j] + 1;
				}
			}
			if (minJumps != Integer.MAX_VALUE) {
				dp[i] = minJumps;
			}
		}
		
		return dp[0];
	}
	
	// Using Greedy (Optimised)
	private static int findMaxIdx(int[] nums, int s, int e) {
		int maxIdx = s;
		int ele = nums[maxIdx];
		
		for (int i = s; i <= e; i++) {
			if (nums[i] + i > ele + maxIdx) {
				maxIdx = i;
				ele = nums[i];
			}
		}
		
		return maxIdx;
	}
	
	public static int jumpOpt(int[] nums) {
		int n = nums.length;
		
		if (n == 1) {
			return 0;
		}
		
		int jumpCnt = 0;
		int maxIdx = 0;
		
		while (maxIdx < n) {
			jumpCnt++;
			
			if (maxIdx + nums[maxIdx] >= n - 1) {
				break;
			}
			
			maxIdx = findMaxIdx(nums, maxIdx + 1, maxIdx + nums[maxIdx]);
		}
		
		return jumpCnt;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		
		System.out.println(jump(nums));
		System.out.println(jumpOpt(nums));
	}
}
