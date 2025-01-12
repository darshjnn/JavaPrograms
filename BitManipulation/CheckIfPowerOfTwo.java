package BitManipulation;

import java.util.Scanner;

public class CheckIfPowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number to check if it is power of 2: ");
		int n = sc.nextInt();
		System.out.println(isPowerOfTwo(n));

		sc.close();
	}
}