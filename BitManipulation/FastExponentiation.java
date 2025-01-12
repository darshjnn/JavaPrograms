package BitManipulation;

import java.util.Scanner;

public class FastExponentiation {
	public static int fastExpo(int n, int pow) {
		int ans = 1;
		
		while (pow > 0) {
			if ((pow & 1) != 0) {
				ans *= n;
			}
			n *= n;
			pow >>= 1;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();
		System.out.print("Enter pow: ");
		int pow = sc.nextInt();
		System.out.println("The fast exponentiation is " + fastExpo(n, pow));

		sc.close();
	}
}