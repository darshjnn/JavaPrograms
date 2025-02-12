/*
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot
index k (1 <= k < nums.length) such that the resulting array is
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(logn) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

*/

package Sorting.LeetCode;

public class SearchInRotatedSortedArray {
	public static int search(int[] arr, int target, int si, int ei) {
		if (si > ei) {
			return -1;
		}
		
		int mid = si + (ei - si) / 2;
		
		if (arr[mid] == target) {
			return mid;
		}
		
		if (arr[si] <= arr[mid]) {
			if (arr[si] <= target && target < arr[mid]) {
				return search(arr, target, si, (mid - 1));
			} else {
				return search(arr, target, (mid + 1), ei);
			}
		} else {
			if (arr[mid] < target && target <= arr[ei]) {
				return search(arr, target, (mid + 1), ei);
			} else {
				return search(arr, target, si, (mid - 1));
			}
		}
	}
	
	public static int search(int[] arr, int target) {
		return search(arr, target, (0), (arr.length - 1));
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		int target = 10;
		
		System.out.println(search(arr, target));
	}
}
