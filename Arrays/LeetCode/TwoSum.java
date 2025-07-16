/*
1. Two Sum Problem

Given an array of integers nums and an integer target, return indices of the two numbers such
that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same
element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

*/
package Arrays.LeetCode;

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = target - nums[i];

            if (!map.containsKey(val)) {
                map.put(nums[i], i);
            } else {
                int index = map.get(val);
                return new int[] {index, i};
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 7, 11, 15 };
        int[] arr = { 3, 2, 4 };
        int target = 6;

        int[] twoSum = twoSum(arr, target);
        System.out.println(Arrays.toString(twoSum));
    }
}

/*
More Straight Foreword Approach:

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int val = target - nums[i];

            if (map.containsKey(val) && i != map.get(val)) {
                result[0] = i;
                result[1] = map.get(val);
                break;
            }
        }

        return result;
    }
 */