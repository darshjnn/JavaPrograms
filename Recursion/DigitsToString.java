/*
Number to corresponding digit String

You are given a number (eg - 2019), convert it into a String of english like
“two zero one nine”.  Use a recursive function to solve this problem.

Input: num = 1947
Output: str[] = ["one","nine","four","seven"]

*/

package Recursion;

import java.util.Arrays;

public class DigitsToString {
	static String[] digit = {"zero", "one", "two", "three", "four", "five", "six",
								"seven", "eight", "nine"};
	
	public static void convert(int num, int len, int idx, String[] result) {
		if (idx >= len || idx < 0) {
			return;
		}
		
		int lastDigit = num % 10;
		num = num / 10;
		result[len - idx - 1] = digit[lastDigit];
		convert(num, len, idx + 1, result);
	}
	
	public static String[] digitToString(int num) {
		int len = (int) Math.log10(num) + 1;
		String[] result = new String[len];
		convert(num, len, 0, result);
		return result;
	}
	
	public static void main(String[] args) {
		int num = 23110;
		System.out.println("\n" + num);
		
		String[] result = digitToString(num);
		System.out.println(Arrays.toString(result));
	}
}
