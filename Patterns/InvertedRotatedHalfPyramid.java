package Patterns;

import java.util.Scanner;

public class InvertedRotatedHalfPyramid {
	public static void invertedRotatedHalfPyramid(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = i - 1; j > 0; j--) {
				System.out.print("   ");
			}
			
			for (int j = height - i; j >= 0; j--) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nHalf Pyramid faced by Horizontal & Vertical Mirrors\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of height: ");
		int height = sc.nextInt();
		
		invertedRotatedHalfPyramid(height);

		sc.close();
	}
}