/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all the following rules:
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.

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

Output: 
[["5","3","4","6","7","8","9","1","2"]
,["6","7","2","1","9","5","3","4","8"]
,["1","9","8","3","4","2","5","6","7"]
,["8","5","9","7","6","1","4","2","3"]
,["4","2","6","8","5","3","7","9","1"]
,["7","1","3","9","2","4","8","5","6"]
,["9","6","1","5","3","7","2","8","4"]
,["2","8","7","4","1","9","6","3","5"]
,["3","4","5","2","8","6","1","7","9"]]

*/

package BackTracking.LeetCode;

import java.util.Arrays;

public class SudokuSolver {
	public static boolean isSafe(char[][] board, int val, int row, int col) {
		// Row
		for (int j = 0; j < 9; j++) {
			if (val == board[row][j] - '0') {
				return false;
			}
		}

		// Column
		for (int i = 0; i < 9; i++) {
			if (val == board[i][col] - '0') {
				return false;
			}
		}

		// Grid
		int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < (startRow + 3); i++) {
            for (int j = startCol; j < (startCol + 3); j++) {
                if (val == board[i][j] - '0') {
                    return false;
                }
            }
        }

		return true;
	}

	public static boolean solveSudoku(char[][] board, int row, int col) {
		if (row == 9) {
			return true;
		}

		int nextRow = row, nextCol = col + 1;
		if (nextCol == 9) {
			nextRow = row + 1;
			nextCol = 0;
		}

		if (board[row][col] != '.') {
			return solveSudoku(board, nextRow, nextCol);
		}

		for (int i = 1; i <= 9; i++) {
			if (isSafe(board, i, row, col)) {
				board[row][col] = Integer.toString(i).charAt(0);

				if (solveSudoku(board, nextRow, nextCol)) {
					return true;
				}

				board[row][col] = '.';
			}
		}

		return false;
	}

	public static void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}
	
	public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
		
		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}

		solveSudoku(board);
		System.out.println("\nAfter Solving:\n");

		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}
	}
}
