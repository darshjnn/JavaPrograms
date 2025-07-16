/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no
two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the
answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q'
and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

Example 2:
Input: n = 1
Output: [["Q"]]

*/

/*
Time Complexity: O(n!).
*/

package BackTracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static boolean isSafe(char[][] board, int row, int col) {
		int n = board.length;
		// Vertical
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}
		
		// Diagonal Up-Right
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		
		// Diagonal Up-Left
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	
	public static void solve(char[][] board, List<List<String>> result, int row) {
		if (row >= board.length) {
			StringBuilder sb = new StringBuilder();
			List<String> temp = new ArrayList<>();
			
			for (char[] chars : board) {
				for (int j = 0; j < board.length; j++) {
					if (chars[j] == 'Q') {
						sb.append(chars[j]);
					} else {
						sb.append('.');
					}
				}
				temp.add(sb.toString());
				sb = new StringBuilder();
			}
			
			result.add(temp);
			return;
		}
		
		for (int j = 0; j < board.length; j++) {
			if (isSafe(board, row, j)) {
				board[row][j] = 'Q';
				solve(board, result, row + 1);
				board[row][j] = '.';
			}
		}
	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		
		solve(board, res, 0);
		
		return res;
	}
	
	public static void main(String[] args) {
		int n = 4;
		List<List<String>> board = solveNQueens(n);
		
		System.out.println(board);
	}
}
