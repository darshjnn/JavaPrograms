/*
733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel
value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the
image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 
4-directionally to the starting pixel of the same color as the starting pixel, plus any 
pixels connected 4-directionally to those pixels (also with the same color), and so on. 
Replace the color of all the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red 
pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the 
blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to
the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.

*/

package TwoDArray.LeetCode;

import java.util.Arrays;

public class FloodFill {
	public static void changeColor(int[][] image, boolean[][] vis, int x, int y,
			int prevColor, int color) {
		if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && !vis[x][y]
				&& image[x][y] == prevColor) {
			vis[x][y] = true;
			image[x][y] = color;

			changeColor(image, vis, x - 1, y, prevColor, color);
			changeColor(image, vis, x, y - 1, prevColor, color);
			changeColor(image, vis, x + 1, y, prevColor, color);
			changeColor(image, vis, x, y - 1, prevColor, color);
		}
	}

	public static void floodFill(int[][] image, int sr, int sc, int color) {
		boolean[][] vis = new boolean[image.length][image[0].length];
		changeColor(image, vis, sr, sc, image[sr][sc], color);
	}

	public static void main(String[] args) {
		int[][] image = { { 0, 0, 0 }, { 0, 1, 0 } };
		System.out.println("\nBefore Flood Fill...");

		for (int[] arr : image) {
			System.out.println(Arrays.toString(arr));
		}

		System.out.println();

		System.out.println("\nAfter Flood Fill...");
		floodFill(image, 1, 1, 2);

		for (int[] arr : image) {
			System.out.println(Arrays.toString(arr));
		}

		System.out.println();
	}
}