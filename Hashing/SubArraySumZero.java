/*
Longest Subarray with Sum Zero

Given an array arr[], find the length of the longest subarray with a sum equal to 0.

Example 1:
Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
Output: 5
Explanation: The longest subarray with sum equals to 0 is {-2, 2, -8, 1, 7}

Example 2:
Input: arr[] = {1, 2, 3}
Output: 0
Explanation: There is no subarray with sum 0

Example 3:
Input:  arr[] = {1, 0, 3}
Output:  1
Explanation: The longest subarray with a sum equal to 0 is {0}

*/

package Hashing;

import java.util.HashMap;

public class SubArraySumZero {
	public static int maxLen(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int len = 0;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				len = i - map.get(sum);
			} else {
				map.put(sum, i);
			}
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
		int subArrSumZero = maxLen(arr);
		System.out.println("Longest Subarray with Sum Zero: " + subArrSumZero);
	}
}
