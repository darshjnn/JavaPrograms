/*
322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.

Return the lowest number of coins that you need to make up that amount.

If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite amount of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

*/

package DynamicProgramming.LeetCode;

import java.util.Arrays;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		int[] minCoins = new int[amount + 1];
		Arrays.fill(minCoins, amount + 1);
		
		minCoins[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i < amount + 1; i++) {
				minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
			}
		}
		
		return minCoins[amount] > amount ? -1 : minCoins[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = {186, 419, 83, 408};
		int amount = 6249;
		
		System.out.println(coinChange(coins, amount));
	}
}
