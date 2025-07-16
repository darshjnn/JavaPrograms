/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

*/

package Strings.LeetCode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s.isBlank()) {
			return true;
		}
		
		String str = s.toLowerCase();
		int n = str.length();
		
		int l = 0, r = n - 1;
		while (l < r) {
			char left = str.charAt(l), right = str.charAt(r);
			
			if (!(left >= 'a' && left <= 'z') && !(left >= '0' && left <= '9')) {
					++l;
					continue;
			}
			
			if (!(right >= 'a' && right <= 'z') && !(right >= '0' && right <= '9')) {
					--r;
					continue;
			}
			
			if (left != right) {
				return false;
			} else {
				++l;
				--r;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
//		String s = "A man, a plan, a canal: Panama";
		String s = ", j, :J";
		System.out.println(isPalindrome(s));
	}
}