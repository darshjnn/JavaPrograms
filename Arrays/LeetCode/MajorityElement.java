/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that
the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

*/

package Arrays.LeetCode;

import java.util.Arrays;

public class MajorityElement {
	public static int count(int[] nums, int target, int si, int hi) {
		int count = 0;
		
		for (int i = si; i <= hi; i++) {
			if (nums[i] == target) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int majorityElement(int[] nums, int si, int hi) {
		if (si >= hi) {
			return nums[si];
		}
		
		int mid = si + (hi - si) / 2;
		
		int left = majorityElement(nums, si, mid);
		int right = majorityElement(nums, mid + 1, hi);
		
		if (left == right) {
			return left;
		}
		
		int leftCount = count(nums, left, si, hi);
		int rightCount = count(nums, right, si, hi);
		
		return leftCount > rightCount ? left : right;
	}
	
	public static int majorityElement(int[] nums) {
		return majorityElement(nums, 0, nums.length - 1);
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 1, 1, 2, 1, 2, 1, 1, 3, 4, 5, 6, 4};
		System.out.println(Arrays.toString(nums));
		System.out.println("Majority Element: " + majorityElement(nums));
	}
}

/*
Alternate Solution:

public static int majorityElement(int[] nums) {
    int count = 0;
    int element = 0;

    for (int num : nums) {
        if (count == 0) {
            element = num;
            count++;
        } else if (num == element) {
            count++;
        } else {
            count--;
        }
    }

    return element;
}

*/