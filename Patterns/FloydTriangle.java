package Patterns;

import java.util.Scanner;

public class FloydTriangle {
	public static void floydTriangle(int row) {
		int n = 1;
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(n++ + "  " );
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nFloyd Triangle\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int row = sc.nextInt();
		
		floydTriangle(row);

		sc.close();
	}
}