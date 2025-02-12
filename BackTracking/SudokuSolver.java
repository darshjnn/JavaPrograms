/*
Sudoku Solver

Solve the 9 x 9 Sudoku Board.

*/

package BackTracking;

import java.util.Arrays;

public class SudokuSolver {
	public static boolean isSafe(int[][] board, int row, int col, int digit) {
		// Column
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == digit) {
				return false;
			}
		}
		
		// Row
		for (int j = 0; j < 9; j++) {
			if (board[row][j] == digit) {
				return false;
			}
		}
		
		// 3 x 3 Grid
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < (startRow + 3); i++) {
			for (int j = startCol; j < (startCol + 3); j++) {
				if (board[i][j] == digit) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean solveSudoku(int[][] board, int row, int col) {
		if (row == 9) {
			return true;
		}
		
		int nextRow = row, nextCol = col + 1;
		if (nextCol == 9) {
			nextRow = row + 1;
			nextCol = 0;
		}
		
		if (board[row][col] != 0) {
			return solveSudoku(board, nextRow, nextCol);
		}
		
		for (int i = 1; i <= 9; i++) {
			if (isSafe(board, row, col, i)) {
				board[row][col] = i;
				if (solveSudoku(board, nextRow, nextCol)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		
		return false;
	}
	
	public static boolean solveSudoku(int[][] board) {
		return solveSudoku(board, 0, 0);
	}
	
	public static void main(String[] args) {
		int[][] sudoku = {
				{0, 0, 8, 0, 0, 0, 0, 0, 0},
				{4, 9, 0, 1, 5, 7, 0, 0, 2},
				{0, 0, 3, 0, 0, 4, 1, 9, 0},
				{1, 8, 5, 0, 6, 0, 0, 2, 0},
				{0, 0, 0, 0, 2, 0, 0, 6, 0},
				{9, 6, 0, 4, 0, 5, 3, 0, 0},
				{0, 3, 0, 0, 7, 2, 0, 0, 4},
				{0, 4, 9, 0, 3, 0, 0, 5, 7},
				{8, 2, 7, 0, 0, 9, 0, 1, 3}
		};
		
		for (int[] s : sudoku) {
			System.out.println(Arrays.toString(s));
		}
		
		System.out.println("\nAfter Solving Sudoku: ");
		
		if (solveSudoku(sudoku)) {
			for (int[] s : sudoku) {
				System.out.println(Arrays.toString(s));
			}
		} else {
			System.out.println("No solution...");
		}
	}
}
