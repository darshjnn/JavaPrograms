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

/*
This approach fails in cases where all the letters ar same, because it is Recursion without
memoization.

For example:
s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
wordDict = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

*/

package Tries;

public class WordBreakBrute {
	public static Trie trie = new Trie();
	
	public static boolean wordBreak(String key) {
		if (key.isEmpty()) {
			return true;
		}

		for (int i = 1; i <= key.length(); i++) {
			if (trie.search(key.substring(0, i)) && wordBreak(key.substring(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
		String key = "ilikesamsung";
		
		for (String word : words) {
			trie.insert(word);
		}
		
		System.out.println(wordBreak(key));
	}
}