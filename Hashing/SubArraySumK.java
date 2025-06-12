/*
Maximum Subarray with Sum K

Given an array a[], find the number of subarrays in it, which have a sum of k.

Example 1:
Input: arr[] = [10, 2, -2, -20, 10], k = -10
Output: 3
Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.

Example 2:
Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.

Example 3:
Input: arr[] = [1, 3, 5], k = 2
Output: 0
Explanation: No subarrays with sum 0.

*/

package Hashing;

import java.util.HashMap;

public class SubArraySumK {
	public static int countSubarraySumK(int[] arr, int k) {
		int count = 0;
		// HashMap will contain key value a pair of (Subarray Sum, Count of that sum appeared)
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// Cover the case when currSum - K = 0
		map.put(0, 1);
		
		// Concept: Prefix Sum.
		// ArraySum[0, j] - ArraySum[0, i] = K, j > i, is the required condition.
		int sum = 0;
		for (int j : arr) {
			sum += j;
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
				map.put(sum, map.get(sum - k) + 1);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 2, -2, -20, 10};
		int k = -10;
		
		System.out.println(countSubarraySumK(arr, k));
	}
}
