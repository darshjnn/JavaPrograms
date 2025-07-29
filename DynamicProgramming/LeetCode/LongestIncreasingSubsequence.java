/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing
subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore, the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

*/

package DynamicProgramming.LeetCode;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    // Aam Zindagi: O(m * n)
    // Create a copy of the array with unique elements; sort the original array; find LCS
    public static int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int[] sorted = new int[set.size()];
        int i = 0;
        for (int x : set) {
            sorted[i++] = x;
        }

        Arrays.sort(sorted);

        return lcs(nums, sorted);
    }

    // LCS - Longest Common Subsequence
    public static int lcs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // Mentos Zindagi: Optimised Approach
    public static int lengthOfLISOpt(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > list.getLast()) {
                list.add(nums[i]);
            } else {
                int low = Collections.binarySearch(list, nums[i]);
                if (low < 0) {
                    low = Math.abs(low + 1);
                    list.set(low, nums[i]);                    
                }
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLISOpt(arr));
    }
}
