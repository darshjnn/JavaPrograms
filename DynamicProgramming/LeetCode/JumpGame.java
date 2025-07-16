/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
            which makes it impossible to reach the last index.

*/

package DynamicProgramming.LeetCode;

public class JumpGame {
    // Aam Zindagi
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                int maxJump = nums[i];
                for (int j = i + 1; j <= i + maxJump; j++) {
                    if (j >= n) {
                        break;
                    }
                    dp[j] = true;
                }
            } else {
                return false;
            }
        }

        return dp[n - 1];
    }

    // Mentos Zindagi
    public static boolean canJumpOpt(int[] nums) {
        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };

        System.out.println(canJump(nums));
        System.out.println(canJumpOpt(nums));
    }
}
