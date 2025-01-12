package Patterns;

import java.util.Scanner;

public class InvertedHalfPyramid {
	public static void invertedHalfPyramid(int height) {
		for (int i = 0; i < height; i++) {
			for (int j = height; j > i; j--) {
				System.out.print("*  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nHalf Pyramid kept on Horizontal Mirror\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter height of the Pyramid: ");
		int height = sc.nextInt();
		
		invertedHalfPyramid(height);

		sc.close();
	}
}