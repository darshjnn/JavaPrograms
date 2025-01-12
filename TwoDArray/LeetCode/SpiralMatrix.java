/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

package TwoDArray.LeetCode;

import java.util.List;
import java.util.LinkedList;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralOrder = new LinkedList<>();
		
		int row = matrix.length;
		int col = matrix[0].length;
		int startRow = 0;
		int startCol = 0;
		int endRow = row - 1;
		int endCol = col - 1;

		while (startRow <= endRow && startCol <= endCol) {
			// Top
			for (int j = startCol; j <= endCol; j++) {
				spiralOrder.add(matrix[startRow][j]);
			}

			// Right
			for (int i = (startRow + 1); i <= endRow; i++) {
				spiralOrder.add(matrix[i][endCol]);
			}

			// Bottom
			for (int j = (endCol - 1); j >= startCol; j--) {
				if (startRow == endRow) {
					break;
				}
				spiralOrder.add(matrix[endRow][j]);
			}

			// Left
			for (int i = (endRow - 1); i >= (startRow + 1); i--) {
				if (startCol == endCol) {
					break;
				}
				spiralOrder.add(matrix[i][startCol]);
			}

			++startRow;
			--endRow;

			++startCol;
			--endCol;
		}
		
		return spiralOrder;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		List<Integer> spiralOrder = spiralOrder(matrix);
		System.out.println(spiralOrder);
	}
}