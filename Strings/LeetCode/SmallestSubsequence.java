/*
1081. Smallest Subsequence of Distinct Characters

Given a string s, return the lexicographically smallest subsequence of s that contains all 
the distinct characters of s exactly once.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

*/

package Strings.LeetCode;

public class SmallestSubsequence {
	public static String smallestSubsequence(String str) {
		StringBuilder result = new StringBuilder();
		int[] count = new int[26];
		boolean[] flag = new boolean[26];
		
		// Count instances of each character
		for (char ch : str.toCharArray()) {
			++count[ch - 'a'];
		}
		
		// Find the lexicographically smallest subsequence
		for (char ch :  str.toCharArray()) {
			--count[ch - 'a'];
			if (!flag[ch - 'a']) {
				while (!result.isEmpty() && ch < result.charAt(result.length() - 1) &&
						count[result.charAt(result.length() - 1) - 'a'] > 0) {
					flag[result.charAt(result.length() - 1) - 'a'] = false;
					result.deleteCharAt(result.length() - 1);
				}
				
				flag[ch - 'a'] = true;
				result.append(ch);
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String str = "cbacdcbc";
		System.out.println(smallestSubsequence(str));
	}
}
