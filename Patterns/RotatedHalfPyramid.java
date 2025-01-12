package Patterns;

import java.util.Scanner;

public class RotatedHalfPyramid {
	public static void rotatedHalfPyramid(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = height - 1; j >= i; j--) {
				System.out.print("   ");
			}
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nHalf Pyramid in front of Vertical Mirror\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of height: ");
		int height = sc.nextInt();
		
		rotatedHalfPyramid(height);

		sc.close();
	}
}