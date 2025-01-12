package Patterns;

import java.util.Scanner;

public class HalfPyramid {
	public static void halfPyramid(int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nHalf Pyramid of Egypt\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the height of the pyramid : ");
		int length = sc.nextInt();
		
		halfPyramid(length);

		sc.close();
	}
}