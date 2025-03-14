/*
We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
Find minimum no. of coins/notes to make change for a value V.

V = 121
ans = 3 (100+20+1)

V = 590
ans = 4 (500+50+20+20)

*/

package GreedyAlgo;

public class IndianCoins {
    // Works only for Canonical Coin System
    public static int coinChange(int[] denominations, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < denominations[0]) {
            return -1;
        }

        int n = denominations.length;
        int coins = 0;

        for (int i = (n - 1); i >= 0; i--) {
            while (amount >= denominations[i]) {
                ++coins;
                amount -= denominations[i];
            }
        }

        if (coins == 0 || amount != 0) {
            return -1;
        }

        return coins;
    }

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
		int amount = 590;
		System.out.println(coinChange(denominations, amount));
    }
}
