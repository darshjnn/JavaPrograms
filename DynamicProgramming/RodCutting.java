/*
Rod Cutting

Given a rod of length n inches and an array price[]. The array price[i] denotes the value of a
piece of length i. The task is to determine the maximum value obtainable by cutting up the rod
and selling the pieces.

Note: price[] is 1-indexed array.

Example 1:
Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6,
			i.e., 5 + 17 = 22.

Example 2:
Input : price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output : 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1,
			i.e., 8 * price[1] = 8 * 3 = 24.

Example 3:
Input : price[] = [3]
Output : 3
Explanation: There is only 1 way to pick a piece of length 1.

*/

package DynamicProgramming;

public class RodCutting {
	public static int rodCutting(int[] length, int[] prices, int rodLength) {
		int n = length.length;
		int[][] maxProfit = new int[rodLength + 1][n + 1];
		
		for (int i = 1; i < rodLength + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i >= length[j - 1]) {
					// Include
					int include = prices[j - 1] + maxProfit[i - length[j - 1]][j];
					
					// Exclude
					int exclude = maxProfit[i][j - 1];
					
					maxProfit[i][j] = Math.max(include, exclude);
				} else {
					// Exclude, because rodLength < length[j - 1]
					maxProfit[i][j] = maxProfit[i][j - 1];
				}
			}
		}
		
		return maxProfit[rodLength][n];
	}
	
	public static void main(String[] args) {
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
		int rodLength = 8;
		
		System.out.println(rodCutting(length, price, rodLength));
	}
}
