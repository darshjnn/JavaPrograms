/*
84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height
where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

*/

package Stacks.LeetCode;

import java.util.Stack;

public class LargestRectangle {
	@SuppressWarnings("DuplicatedCode")
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] nextSmallerLeft = new int[n];
		int[] nextSmallerRight = new int[n];

		// Calculating First Next Smaller Left
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nextSmallerLeft[i] = -1;
			} else {
				nextSmallerLeft[i] = stack.peek();
			}

			stack.push(i);
		}

		// Calculating First Next Smaller Right
		stack = new Stack<>();
		for (int i = (n - 1); i >= 0; i--) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nextSmallerRight[i] = n;
			} else {
				nextSmallerRight[i] = stack.peek();
			}

			stack.push(i);
		}

		// Calculating Max Area
		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
			int area = heights[i] * width;
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(heights));
	}
}

/*
Alternate Approach:

public static int largestRectangleArea(int[] heights) {
	int n = heights.length;
	int ans = 0;
	int[] nextSmallest = new int[n];
	int[] prevSmallest = new int[n];
	
	nextSmallest[n - 1] = n;
	prevSmallest[0] = -1;
	
	for (int i = 1; i < n; i++) {
		int prev = i - 1;
		
		while (prev >= 0 && heights[prev] >= heights[i]) {
			prev = prevSmallest[prev];
		}
		
		prevSmallest[i] = prev;
	}
	
	for (int i = n - 2; i >= 0; i--) {
		int next = i + 1;
		
		while (next < n && heights[next] >= heights[i]) {
			next = nextSmallest[next];
		}
		nextSmallest[i] = next;
	}
	
	for (int i = 0; i < n; i++) {
		int height = heights[i];
		int width = nextSmallest[i] - prevSmallest[i] - 1;
		ans = Math.max(ans, height * width);
	}
	
	return ans;
}

*/