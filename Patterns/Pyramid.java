package Patterns;

import java.util.Scanner;

public class Pyramid {
	public static void pyramid(int length) {
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= (length - i); j++) {
				System.out.print("   ");
			}
			
			for (int j = 0; j < (2 * i) - 1; j++) {
				System.out.print("*  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Full Pyramid of Egypt");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the height of the Pyramid : ");
		int length = sc.nextInt();
		
		pyramid(length);

		sc.close();
	}
}