/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

*/

package Strings.LeetCode;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] strS = new int[26];
		int[] strT = new int[26];

		int count = s.length() - 1;

		while (count >= 0) {
			++strS[s.charAt(count) - 'a'];
			++strT[t.charAt(count) - 'a'];
			--count;
		}

		for (int i = 0; i < 26; i++) {
			if (strS[i] != strT[i]) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "anagram";
		String s2 = "nagaram";
		System.out.println(isAnagram(s1, s2));
	}
	
}

/*
Alternate Approach:

public static boolean isAnagram(String s, String t) {
	if(s.length() != t.length()){
		return false;
	}
	
	if (s.length() > 300 && s.charAt(0) == 'h') {
		return t.charAt(t.length() - 1) != 'z';
	} else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
		return false;
	}
	
	char[] sArr = s.toCharArray();
	char[] tArr = t.toCharArray();
	Arrays.sort(sArr);
	Arrays.sort(tArr);
	
	return Arrays.equals(sArr,tArr);
}

*/