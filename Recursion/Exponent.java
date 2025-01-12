/*
Calculate x^n

*/

package Recursion;

public class Exponent {
	// Aam Zindagi: Normal Approach Time Complexity - O(e)
	public static int pow(int n, int e) {
		if (e <= 0) {
			return 1;
		}
		
		return n * pow(n, e - 1);
	}
	
	// Mentos Zindagi: Optimised Approach Time Complexity- O(loge)
	public static int powOptimized(int n, int e) {
		if (e <= 0) {
			return 1;
		}
		
		int halfPower = powOptimized(n, e / 2);
		
		if (e % 2 == 0) {
			return halfPower * halfPower;
		} else {
			return n * halfPower * halfPower;
		}
	}
	
	public static void main(String[] args) {
		int base = 2;
		int exponent = 10;
		
		System.out.println(pow(base, exponent));
		System.out.println(powOptimized(base, exponent));
	}
}