/*
503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is 
nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next
in the array, which means you could search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.

Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

*/

package Stacks.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    // Normal Zindagi
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && nums[i] >= s.peek()) {
                s.pop();
            }

            if (s.isEmpty()) {
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    int index = (i + j) % n;
                    if (nums[index] > nums[i]) {
                        res[i] = nums[index];
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    res[i] = -1;
                }
            } else {
                res[i] = s.peek();
            }

            s.push(nums[i]);
        }

        return res;
    }

    // Mentos Zindagi
    public static int[] nextGreaterElementsOpt(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int stack[] = new int[2 * n];
        int top = -1;

        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            while (top >= 0 && nums[stack[top]] < num) {
                result[stack[top]] = num;
                top--;
            }

            if (i < n) {
                top++;
                stack[top] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
        System.out.println(Arrays.toString(nextGreaterElementsOpt(nums)));
    }
}
