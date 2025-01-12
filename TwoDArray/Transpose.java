package TwoDArray;

import java.util.Arrays;

public class Transpose {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] =  matrix[i][j];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] transpose = transpose(matrix);
        
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(transpose));
    }
}
