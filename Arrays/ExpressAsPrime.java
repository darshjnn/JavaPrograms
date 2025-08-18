/*
Check if a number can be expressed as a sum of two Prime Numbers

Given a number n, the task is to check if it is possible to express n as the sum of two
prime numbers, a and b. If such a pair does not exist, return [-1, -1].

Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with
		c <= d, and a < c then [a, b] is considered as our answer.

Example 1:
Input: n = 19
Output: Yes
Explanation: The number 19 can be written as 17 + 2, here 17 and 2 are both primes.

Example 2:
Input: n = 14
Output: Yes
Explanation: The number 14 can be written as 7 + 7.

Example 3:
Input: n = 11
Output: No

*/

package Arrays;

public class ExpressAsPrime {
	public static boolean isPrimeSumPair(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				System.out.println("Pair: " + i + " " + (num - i));
				return true;
			}
		}
		
		return false;
	}
	
	// Check if a number is Prime
	public static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 14;
		System.out.println(isPrimeSumPair(n));
	}
}
