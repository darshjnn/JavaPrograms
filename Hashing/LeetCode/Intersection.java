/*
349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique, and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

*/

package Hashing.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> set1 = new HashSet<>();
		
		for (int i : nums1) {
			set1.add(i);
		}
		
		for (int i : nums2) {
			if (set1.contains(i)) {
				set.add(i);
			}
		}
		
		int[] result = new int[set.size()];
		int i = 0;
		for (Integer integer : set) {
			result[i++] = integer;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {1, 2, 2, 1, 1, 3};
		
		int[] intersection = intersection(nums1, nums2);
		System.out.println(Arrays.toString(intersection));
	}
}
