/*
1572. Matrix Diagonal Sum

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: matrix = [[1,2,3],
                [4,5,6],
                [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:
Input: matrix = [[1,1,1,1],
                [1,1,1,1],
                [1,1,1,1],
                [1,1,1,1]]
Output: 8

Example 3:
Input: mat = [[5]]
Output: 5

*/

package TwoDArray.LeetCode;

public class DiagonalSum {
    // Normal Zindagi: Brute Force Approach - O(n^2)
    public static int bruteDiagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - j) == 0 || (i + j) == (n - 1)) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    // Mentos Zindagi: Optimized Approach - O(n)
    public static int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (i != n - i - 1) {
                sum += matrix[i][n - i - 1];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 8 } };
        
        System.out.println(bruteDiagonalSum(matrix));
        System.out.println(diagonalSum(matrix));

    }
}