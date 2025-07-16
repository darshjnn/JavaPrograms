/*
42. Trapping Rainwater

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rainwater (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

*/

package Arrays.LeetCode;

public class TrappingRainwater {
	public static int trap(int[] height) {
		int n = height.length;
		
		if (n == 1) {
			return 0;
		}
		
		int[] leftMax = new int[n];
		leftMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		int[] rightMax = new int[n];
		rightMax[n - 1] = height[n - 1];
		for (int i = (n - 2); i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		int trappedWater = 0;
		for (int i = 0; i < n; i++) {
			int waterLevel = Math.min(leftMax[i], rightMax[i]);
			trappedWater += waterLevel - height[i];
		}

		return trappedWater;
	}
	
	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.print("Trapped water: ");
		System.out.println(trap(height));
	}
}

/*
Alternate Approach:

	public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                ++left;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                --right;
            }
        }
        
        return ans;
    }
    
*/