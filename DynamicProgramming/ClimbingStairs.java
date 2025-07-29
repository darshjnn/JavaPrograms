/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
                1. 1 step + 1 step
                2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step

*/

package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
	// Recursion - O(2^n)
	public static int climbingStairsRec(int n) {
		if (n <= 0 || n == 1) {
			return 1;
		}
		
		return climbingStairsRec(n - 1) + climbingStairsRec(n - 2);
	}
	
	// Recursion + Memoization - O(n)
	public static int climbingStairsMem(int n, int[] ways) {
		if (n <= 0 || n == 1) {
			return 1;
		}
		
		if (ways[n] != -1) {
			return ways[n];
		}
		
		return climbingStairsMem(n - 1, ways) + climbingStairsMem(n - 2, ways);
	}
	
	// Tabulation
	public static int climbingStairsTab(int n) {
		if (n <= 0 || n == 1) {
			return 1;
		}
		
		int[] ways = new int[n + 1];
		Arrays.fill(ways, -1);
		
		ways[0] = ways[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		
		return ways[n];
	}
	
	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(climbingStairsRec(n));
		
		int[] ways = new int[n + 1];
		Arrays.fill(ways, -1);
		System.out.println(climbingStairsMem(n, ways));
		
		System.out.println(climbingStairsTab(n));
	}
}
