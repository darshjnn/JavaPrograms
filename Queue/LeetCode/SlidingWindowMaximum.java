/*
239. Sliding Window Maximum


You are given an array of integers nums, there is a sliding window of size k which is moving
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

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    // Aam Zindagi
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }

        int size = nums.length - k + 1;
        int[] max = new int[size];

        // Finding max from first window & pushing in queue
        int windowMax = nums[0], index = 0;
        for (int i = 1; i < k; i++) {
            if (windowMax < nums[i]) {
                windowMax = nums[i];
                index = i;
            }
        }
        max[0] = windowMax;

        int left = 1, right = k;

        for (int i = 1; i < size; i++) {
            if (index < left) {
                // Find & push new window max
                windowMax = nums[left];
                for (int j = left; j <= right; j++) {
                    if (windowMax < nums[j]) {
                        windowMax = nums[j];
                        index = j;
                    }
                }
            }

            if (windowMax <= nums[right]) {
                index = right;
                windowMax = nums[right];
            }

            max[i] = windowMax;
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
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && (dq.peekFirst() == (i - k))) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (!dq.isEmpty() && i >= (k - 1)) {
                max[right++] = nums[dq.peekFirst()];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] nums = { 7,2,4 };
        int k = 2;

        int[] max = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(max));

        int[] max2 = maxSlidingWindowOptimised(nums, k);
        System.out.println(Arrays.toString(max2));
    }
}