/*
1207. Unique Number of Occurrences

Given an array of integer arr, return true if the number of occurrences for each value in the
array is unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same
number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

*/

package Hashing.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
	public static boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (set.contains(entry.getValue())) {
				return false;
			}
			set.add(entry.getValue());
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 1, 1, 3};
		System.out.println(uniqueOccurrences(arr));
	}
}
