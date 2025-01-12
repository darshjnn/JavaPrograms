package Patterns;

import java.util.Scanner;

public class HollowRectangle {
	public static void hollowRectangle(int length, int width) {
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= width; j++) {
				if (i == 1 || i == length || j == 1 || j == width) {
					System.out.print("*  ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSolid from Out, Hollow from In Rectangle :( \n");
		
		System.out.print("Enter Length: ");
		int length = sc.nextInt();
		
		System.out.print("Enter Width: ");
		int width = sc.nextInt();
		
		hollowRectangle(length, width);

		sc.close();
	}
}