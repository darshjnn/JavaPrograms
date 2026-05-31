/*
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

*/

package Hashing.LeetCode;

import java.util.*;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		boolean[] track = new boolean[s.length() + 1];
		track[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (track[j] && dict.contains(s.substring(j, i))) {
					track[i] = true;
					break;
				}
			}
		}
		
		return track[s.length()];
	}
	
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		
		System.out.println(wordBreak("leetcode", wordDict));
	}
}
