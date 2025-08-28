/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

*/

package Arrays.LeetCode;

import java.util.Arrays;

public class RotateArray {
	// Normal Zindagi: Brute Force Approach (Using extra space by creating an Array)
	// Time Complexity: O(n + k); Space Complexity: O(k)
	public static void rotateBrute(int[] nums, int k) {
		int n = nums.length;

		if (k == n) {
			return;
		}

		if (k > n) {
			k %= n;
		}

		// Create a copy of last k-elements
		int[] temp = Arrays.copyOfRange(nums, n - k, n);

		// Shift the starting elements by k-steps
		for (int i = n - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}

		// Place the remaining elements at their right place
		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
	}

	// Mentos Zindagi: By reversing elements
	public static void rotateOpt(int[] nums, int k) {
		int n = nums.length;
		
		if (n == k) {
			return;
		}

		if (n < k) {
			k %= n;
		}

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	// Reverse the elements of an array in the given range of index
	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 99, -1, -100, 3 };
		int k = 2;
		System.out.println(Arrays.toString(nums));

		System.out.println("\nNormal Zindagi:");
		int[] tempForBrute = nums.clone();
		rotateBrute(tempForBrute, k);
		System.out.println(Arrays.toString(tempForBrute));

		System.out.println("\nMentos Zindagi:");
		int[] tempForOpt = nums.clone();
		rotateOpt(tempForOpt, k);
		System.out.println(Arrays.toString(tempForOpt));
	}
}
