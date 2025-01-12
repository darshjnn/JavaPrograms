/*
Next Greater Element Array

Given an integer array nums[]. Return an array of element containing next greater elements of
element of nums[].

The next greater element of some element x in an array is the first greater element that is to
the right of x in the same array.
If there is no next greater element, then the answer for this query is -1.

All elements of nums are unique.

Example 1:
Input: nums = [1,3,4,2]
Output: result = [3,4,-1,-1]

Example 2:
Input: nums = [6,5,7,4,3]
Output: result = [7,7,-1,-1,-1]

*/

package Stacks;

import java.util.Stack;

public class NextGreaterElementArray {
	public static int[] nextGreaterElement(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			
			stack.push(nums[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int[] result = nextGreaterElement(nums);
		
		for (int j : result) {
			System.out.print(j + "  ");
		}
		System.out.println();
	}
}