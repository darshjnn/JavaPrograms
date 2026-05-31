/*
720. Longest Word in Dictionary

Given an array of strings words representing an English Dictionary, return the longest word in
words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest
lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added
to the end of a previous word.

Example 1:
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary.
			However, "apple" is lexicographically smaller than "apply".

*/

/*
Another way of this Question:

Longest Word With All Prefixes
Find the longest string in words such that every prefix of it is also in words.
Return the lexicographically smallest string which is longest in length.

*/

package Tries.LeetCode;

import Tries.Nodes.TrieNode;
import Tries.Trie;

public class LongestWordInDictionary {
	public static void getLongestWord(TrieNode root, StringBuilder result, StringBuilder temp) {
		if (root == null) {
			return;
		}
		
		// For lexicographically smallest, start the loop with i = 0
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null && root.children[i].eow) {
				temp.append((char) ('a' + i));
				
				if (temp.length() > result.length()) {
					// If prefix = temp is used, then both will point to same object
					// And, changes to one will affect the other.
					result.setLength(0);
					result.append(temp);
				}
				
				getLongestWord(root.children[i], result, temp);
				temp.deleteCharAt(temp.length() - 1); // Backtrack
			}
		}
	}
	
	public static String longestWord(String[] words) {
		// Initialising Trie
		Trie trie = new Trie();
		
		for (String word : words) {
			trie.insert(word);
		}
		
		StringBuilder result = new StringBuilder();
		getLongestWord(trie.root, result, new StringBuilder());
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String[] words = {"w", "wo", "wor", "worl", "world"};
		
		System.out.println(longestWord(words));
	}
}
