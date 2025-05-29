/*
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k that is moving
from the very left of the array to the very right. You can only see the k numbers in the
window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

*/

package Queue.LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	// Aam Zindagi
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (k <= 1) {
			return nums;
		}
		
		int size = nums.length - k + 1;
		int[] max = new int[size];
		int winMax = nums[0];
		
		int index = -1, left = 0, right = k - 1;
		for (int i = 0; i < size; i++) {
			if (left > index) {
				winMax = nums[left];
				for (int j = left; j < right; j++) {
					if (winMax < nums[j]) {
						winMax = nums[j];
						index = j;
					}
				}
			}
			
			if (winMax <= nums[right]) {
				winMax = nums[right];
				index = i;
			}
			
			max[i] = winMax;
			++left;
			++right;
		}
		
		return max;
	}
	
	// Mentos Zindagi
	public static int[] maxSlidingWindowOptimised(int[] nums, int k) {
		if (k <= 1) {
			return nums;
		}
		
		int size = nums.length - k + 1;
		int[] max = new int[size];
		Deque<Integer> dq = new LinkedList<>();
		int index = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (!dq.isEmpty() && (dq.peekFirst() == (i - k))) {
				dq.removeFirst();
			}
			
			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
			
			if (!dq.isEmpty() && i >= (k - 1)) {
				max[index++] = nums[dq.peekFirst()];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
//		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] nums = {7, 2, 4};
		int k = 2;
		
		int[] max = maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(max));
		
		int[] max2 = maxSlidingWindowOptimised(nums, k);
		System.out.println(Arrays.toString(max2));
	}
}