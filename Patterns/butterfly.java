package Patterns;

import java.util.Scanner;

public class Butterfly {
	public static void butterfly(int rows) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*  ");
			}
			
			for (int j = 0; j < (rows - i - 1); j++) {
				System.out.print("      ");
			}
			
			for (int j = 0; j <= i; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
		
		
		for (int i = rows; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*  ");
			}
			
			for (int j = 0; j < (rows - i); j++) {
				System.out.print("      ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\nButterflies from the Stomach\n");
		
		System.out.print("Enter the number of rows: ");
		int rows = sc.nextInt();
		
		System.out.println();
		butterfly(rows);
		
		sc.close();
	}
}