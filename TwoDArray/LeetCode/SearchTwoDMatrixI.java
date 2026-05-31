/*
74. Search a 2D Matrix I

You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

*/

package TwoDArray.LeetCode;

public class SearchTwoDMatrixI {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int col = getCol(matrix, target, m, 0, n);

        if (col == -1) {
            return false;
        }

        return binarySearch(matrix[col], target, 0, m);
    }

    public static int getCol(int[][] matrix, int target, int columns, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);

        if (target < matrix[mid][columns]) {
            if (target >= matrix[mid][0]) {
                return mid;
            }

            return getCol(matrix, target, columns, low, mid - 1);
        } else if (target > matrix[mid][columns]) {
            return getCol(matrix, target, columns, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static boolean binarySearch(int[] arr, int target, int low, int high) {     
        int mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 10;

        System.out.println(searchMatrix(matrix, target));
    }
}
