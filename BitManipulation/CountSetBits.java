/*
Time Complexity: O(logn), because a number can be represented in (logn + 1) bits.

*/

package BitManipulation;

import java.util.Scanner;

public class CountSetBits {
	public static int countSetBits(int n) {
		int count = 0;
		
		while (n != 0) {
			if ((n & 1) == 1) {
				++count;
			}
			n >>= 1;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number to count set bits: ");
		int n = sc.nextInt();
		System.out.println("No. of set bits: " + countSetBits(n));

		sc.close();
	}
}