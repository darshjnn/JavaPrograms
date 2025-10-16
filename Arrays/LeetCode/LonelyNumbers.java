/*
2150. Find All Lonely Numbers in the Array

You are given an integer array nums. A number x is lonely when it appears only once,
and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.

Return all lonely numbers in nums. You may return the answer in any order.

Example 1:
Input: nums = [10,6,5,8]
Output: [10,8]
Explanation:
- 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
- 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
- 5 is not a lonely number since 6 appears in nums and vice versa.
Hence, the lonely numbers in nums are [10, 8].
Note that [8, 10] may also be returned.

Example 2:
Input: nums = [1,3,5,3]
Output: [1,5]
Explanation:
- 1 is a lonely number since it appears exactly once and 0 and 2 does not appear in nums.
- 5 is a lonely number since it appears exactly once and 4 and 6 does not appear in nums.
- 3 is not a lonely number since it appears twice.
Hence, the lonely numbers in nums are [1, 5].
Note that [5, 1] may also be returned.

*/

package Arrays.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LonelyNumbers {
	public static List<Integer> findLonely(int[] nums) {
		int n = nums.length;
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		
		if (n == 1) {
			list.add(nums[0]);
			return list;
		}
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (nums[i + 1] != nums[i] && nums[i + 1] != (nums[i] + 1)) {
					list.add(nums[i]);
				}
			} else if (i == n - 1) {
				if (nums[i - 1] != nums[i] && nums[i] != (nums[i - 1] + 1)) {
					list.add(nums[i]);
				}
			} else {
				if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
					if (nums[i] != (nums[i - 1] + 1) && nums[i + 1] != (nums[i] + 1)) {
						list.add(nums[i]);
					}
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {10, 6, 5, 8};
		List<Integer> list = findLonely(nums);
		
		System.out.println(list);
	}
}
