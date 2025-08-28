/*
2035. Partition Array Into Two Arrays to Minimize Sum Difference

You are given an integer array nums of 2 * n integers. You need to partition nums into two
arrays of length n to minimize the absolute difference of the sums of the arrays.
To partition nums, put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.

Example 1:
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.

Example 2:
Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.

Example 3:
Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.

*/

package DynamicProgramming.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionArray {
	// This approach works only for Positive values
	// Solved using 0-1 Knapsack
	public static int minimumDifferenceDP(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			if (num < 0) {
				System.out.println("Only positive integers allowed");
				return Integer.MIN_VALUE;
			}
			sum += num;
		}

		int n = nums.length;
		int wt = sum / 2;
		int[][] dp = new int[n + 1][wt + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= wt; j++) {
				if (nums[i - 1] > j) {
					// Exclude
					dp[i][j] = dp[i - 1][j];
				} else {
					// Include
					int include = nums[i - 1] + dp[i - 1][j - nums[i - 1]];

					// Exclude
					int exclude = dp[i - 1][j];

					dp[i][j] = Math.max(include, exclude);
				}
			}
		}

		int sum1 = dp[n][wt];
		int sum2 = sum - sum1;

		return Math.abs(sum1 - sum2);
	}

	// This approach works for All value
	// Solve using meet-in-the-middle approach
	public static int minDiffMeetInMiddle(int[] nums) {
		int n = nums.length;
		int totalSum = Arrays.stream(nums).sum();

		int[] leftArr = Arrays.copyOfRange(nums, 0, (n / 2));
		int[] rightArr = Arrays.copyOfRange(nums, (n / 2), n);

		List<List<Integer>> leftSums = subsetSums(leftArr);
		List<List<Integer>> rightSums = subsetSums(rightArr);

		for (List<Integer> list : rightSums) {
			Collections.sort(list);
		}

		int minDiff = Integer.MAX_VALUE;

		for (int k = 0; k <= (n / 2); k++) {
			List<Integer> leftSubsetSums = leftSums.get(k);
			List<Integer> rightSubsetSums = rightSums.get((n / 2) - k);

			for (int leftSum : leftSubsetSums) {
				int target = (totalSum / 2) - leftSum;
				int index = Collections.binarySearch(rightSubsetSums, target);
				if (index < 0) {
					index = -index - 1;
				}
				for (int i : new int[] { index - 1, index }) {
					if (i >= 0 && i < rightSubsetSums.size()) {
						int sum = leftSum + rightSubsetSums.get(i);
						int diff = Math.abs((totalSum - sum) - sum);
						minDiff = Math.min(minDiff, diff);
					}
				}
			}
		}

		return minDiff;
	}

	// Get sum of all subsets of an array
	public static List<List<Integer>> subsetSums(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		// Initialize sub-lists for sizes 0 to len to store subset sums 
		for (int i = 0; i <= len; i++) {
			res.add(new ArrayList<>());
		}

		// Go through every subset
		for (int mask = 0; mask < (1 << len); mask++) {
			int sum = 0;
			int elements = 0;
			// For each element, check if it's included in this subset
			for (int i = 0; i < len; i++) {
				if ((mask & (1 << i)) != 0) {
					sum += nums[i];
					elements++;
				}
			}

			// Add sum to the group for this subset size
			res.get(elements).add(sum);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, -1, 0, 4, -2, -9 };

		System.out.println(minimumDifferenceDP(nums));
		System.out.println(minDiffMeetInMiddle(nums));
	}
}
