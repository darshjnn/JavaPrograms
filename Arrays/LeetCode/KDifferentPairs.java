/*
532. K-diff Pairs in an Array

Given an array of integers nums and an integer k, return the number of unique k-diff pairs
in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following is true:
	0 <= i, j < nums.length
	i != j
	|nums[i] - nums[j]| == k
	
Notice that |val| denotes the absolute value of val.

Example 1:
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1's in the input, we should only return the number of unique pairs.

Example 2:
Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

*/

package Arrays.LeetCode;

import java.util.HashMap;

public class KDifferentPairs {
	public static int findPairs(int[] nums, int k) {
		int count = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		boolean[] vis = new boolean[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
				if (!vis[map.get(nums[i] + k)]) {
					vis[map.get(nums[i] + k)] = true;
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 1, 5};
		int k = 2;
		
		System.out.println(findPairs(nums, k));
	}
}

/*
Alternate Solution
public int findPairs(int[] nums, int k) {
	Arrays.sort(nums);
	int arrayLength = nums.length;
	int startPoint = 0, nextPoint = 1;
	int ans = 0;
	
	while (startPoint < arrayLength && nextPoint < arrayLength) {
		if (startPoint == nextPoint || nums[nextPoint] - nums[startPoint] < k) {
			nextPoint++;
		} else if (nums[nextPoint] - nums[startPoint] > k) {
			startPoint++;
		} else {
			ans += 1;
			startPoint++;
			nextPoint++;
			
			while (nextPoint < arrayLength && nums[nextPoint] == nums[nextPoint - 1]) {
				nextPoint++;
			}
		}
	}
	
	return ans;
}
 */