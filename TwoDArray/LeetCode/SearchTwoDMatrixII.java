/*
240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value target in an m x n integer matrix. 
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
        target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
        target = 20
Output: false

*/

package TwoDArray.LeetCode;

public class SearchTwoDMatrixII {
	// Normal Zindagi
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix[0].length - 1;
		
		for (int[] row : matrix) {
			if (target < row[m] && binarySearch(row, target, 0, m)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean binarySearch(int[] arr, int target, int low, int high) {
		if (low > high) {
			return false;
		}
		
		int mid = low + ((high - low) / 2);
		
		if (target < arr[mid]) {
			return binarySearch(arr, target, low, mid - 1);
		} else if (target > arr[mid]) {
			return binarySearch(arr, target, mid + 1, high);
		} else {
			return true;
		}
	}
	
	// Mentos Zindagi
	public static boolean searchMatrixOpt(int[][] matrix, int target) {
		int n = matrix.length - 1;
		
		int i = 0, j = matrix[0].length - 1;
		while (i < n && j >= 0) {
			if (target == matrix[i][j]) {
				return true;
			} else if (target < matrix[i][j]) {
				--j;
			} else {
				++i;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		
		int target = 5;
		
		System.out.println(searchMatrix(matrix, target));
		System.out.println(searchMatrixOpt(matrix, target));
	}
}
