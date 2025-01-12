/*
Check if the number is Odd or Even

For Binary numbers, if the number is ODD => The Least Significant Bit = 1
                    if the number is EVEN => The Least Significant Bit = 0

*/

package BitManipulation;

import java.util.*;

public class CheckEvenOdd {
	public static void checkEvenOdd(int n) {
		int bitMask = n & 1;
		
		if (bitMask == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number to check Even or Odd: ");
		int n = sc.nextInt();
		checkEvenOdd(n);

		sc.close();
	}
}