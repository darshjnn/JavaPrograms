package Patterns;

import java.util.Scanner;

public class Kite {
	public static void kite(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= height - i; j++) {
				System.out.print("   ");
			}
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*  ");
			}
			
			for (int j = 1; j < i; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
		
		for (int i = 1; i < height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("   ");
			}
			
			for (int j = height - i; j > 1; j--) {
				System.out.print("*  ");
			}
			
			for (int j = height - i; j >= 1; j--) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nKite of Joy... :) \n");
		
		System.out.print("Enter Height: ");
		int height = sc.nextInt();
		
		kite(height);
		
		sc.close();
	}
}