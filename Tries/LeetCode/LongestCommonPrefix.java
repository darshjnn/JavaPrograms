/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix amongst the input strings.

*/

package Tries.LeetCode;

import Tries.Nodes.TrieNode;
import Tries.Trie;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};
		
		System.out.println(longestCommonPrefixTrie(strs));
		System.out.println(longestCommonPrefixArray(strs));
	}
	
	public static void getLongestCommonPrefix(TrieNode node, StringBuilder prefix, int len) {
		if (node == null || node.frequency == 1) {
			return;
		}
		
		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null && node.children[i].frequency == len) {
				getLongestCommonPrefix(node.children[i], prefix.append((char) ('a' + i)), len);
				return;
			}
		}
	}
	
	// Using Trie
	public static String longestCommonPrefixTrie(String[] strs) {
		Trie trie = new Trie();
		for (String str : strs) {
			trie.insert(str);
		}
		
		StringBuilder prefix = new StringBuilder();
		getLongestCommonPrefix(trie.root, prefix, strs.length);
		
		return prefix.toString();
	}
	
	// Using Arrays
	public static String longestCommonPrefixArray(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		
		return prefix;
	}
}
