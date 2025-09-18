/*
680. Valid Palindrome II

Given a string s, return true if the s can be palindrome after deleting at most one character
from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

*/

package Strings.LeetCode;

public class ValidPalindromeII {
	public static boolean validPalindrome(String s) {
		int n = s.length();

		if (n < 3) {
			return true;
		}

		int l = 0, r = n - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1));
			}

			++l;
			--r;
		}

		return true;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		System.out.println(validPalindrome(s));
	}
}
