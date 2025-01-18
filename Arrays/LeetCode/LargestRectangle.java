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

package Arrays.LeetCode;

public class LargestRectangle {
	@SuppressWarnings("ALL")
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] nextSmallerLeft = new int[n];
		int[] nextSmallerRight = new int[n];
		
		// Calculating First Next Smaller Left
		nextSmallerLeft[0] = -1;
		for (int i = 1; i < n; i++) {
			int prev = i - 1;
			
			while (prev >= 0 && heights[i] <= heights[prev]) {
				prev = nextSmallerLeft[prev];
			}
			
			nextSmallerLeft[i] = prev;
		}
		
		// Calculating First Next Smaller Right
		nextSmallerRight[n - 1] = n;
		for (int i = (n - 2); i >= 0; i--) {
			int next = i + 1;
			
			while (next < n && heights[i] <= heights[next]) {
				next = nextSmallerRight[next];
			}
			
			nextSmallerRight[i] = next;
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
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(largestRectangleArea(heights));
	}
}