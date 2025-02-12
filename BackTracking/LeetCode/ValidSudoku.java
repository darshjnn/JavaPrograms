/*
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.

*/

package BackTracking.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ValidSudoku {
	static boolean isSafe(HashMap<Integer, ArrayList<int[]>> map, int n, int row, int col) {
		if (map.containsKey(n)) {
			ArrayList<int[]> indexes = map.get(n);
			for (int[] index : indexes) {
				int startRow = (index[0] / 3) * 3;
				int startCol = (index[1] / 3) * 3;
				if (index[0] == row || index[1] == col) {
					return false;
				} else if (row >= startRow && row < (startRow + 3) &&
						col >= startCol && col < (startCol + 3)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isValidSudoku(char[][] board) {
		HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
		ArrayList<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int curr = board[i][j] - 'a';
					if (isSafe(map, curr, i, j)) {
						if (map.containsKey(curr)) {
							list = map.get(curr);
						}
						list.add(new int[]{i, j});
						map.put(curr, list);
						list = new ArrayList<>();
					} else {
						return false;
					}
				}
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '.'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '6', '.', '4', '1', '9', '.', '.', '.'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		
		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}
		
		System.out.println("\nIs Valid Sudoku? " + isValidSudoku(board));
	}
}
