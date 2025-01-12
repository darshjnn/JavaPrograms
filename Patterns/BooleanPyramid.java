package Patterns;

import java.util.Scanner;

public class BooleanPyramid {
	public static void booleanPyramid(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				if (j % 2 != 0) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nBoolean Right Angled Triangle\n");
		
		System.out.print("Enter the number of rows: ");
		int rows = sc.nextInt();
		
		booleanPyramid(rows);
		sc.close();
	}
}