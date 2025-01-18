/*
Tiling Problem

Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile the given board
using the 2 x 1 tiles.

(A tile can either be placed horizontally or vertically.)

*/

package Recursion;

public class TilingProblem {
	// n is the floor length, breadth is 2.
	public static int countWays(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int verticalTile = countWays(n - 1);
		int horizontalTile = countWays(n - 2);
		
		return verticalTile + horizontalTile;
	}
	
	public static void main(String[] args) {
		System.out.println(countWays(4));
	}
}