/*
52. N-Queens II

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1

*/

/*
Time Complexity: O(n!).
*/

package BackTracking.LeetCode;

public class NQueensII {
	public static boolean isSafe(char[][] board, int row, int col) {
		int n = board.length;
		
		// Horizontal
		for (int j = col - 1; j >= 0; j--) {
			if (board[row][j] == 'Q') {
				return false;
			}
		}
		
		// Diagonal Up Left
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		
		// Diagonal Down Left
		for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	
	public static int solve(char[][] board, int[] count, int col) {
		if (col >= board.length) {
			return ++count[0];
		}
		
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 'Q';
				solve(board, count, col + 1);
				board[i][col] = '.';
			}
		}
		
		return count[0];
	}
	
	public static int totalNQueens(int n) {
		if (n == 1) {
			return n;
		}
		
		int[] count = new int[1];
		char[][] board = new char[n][n];
		
		return solve(board, count, 0);
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(totalNQueens(n));
	}
}