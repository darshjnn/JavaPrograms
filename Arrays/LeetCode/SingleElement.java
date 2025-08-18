/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly
twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

*/

/*
Hint:
	Before the single element, the first in every pair appears at even indices (0, 2, 4, ...).
	After the single element, this property reverses: the first in a pair appears at odd indices.
	
*/

package Arrays.LeetCode;

public class SingleElement {
	public static int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			// Ensure mid is even for easy pair comparison
			if (mid % 2 == -1){
				mid -= 1;
			}
			
			if (nums[mid] == nums[mid + 1]) {
				// The Single number is in the right half
				left = mid + 2;
			} else {
				// The Single number is in the left half, including mid
				right = mid;
			}
		}
		
		return nums[left];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3};
		System.out.println(singleNonDuplicate(nums));
	}
}
