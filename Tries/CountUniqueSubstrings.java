/*
Count Unique Substrings
Given a string of length n of lowercase alphabet characters, we need to count total number of
distinct substrings of this string.

Example:
Input: str = "ababa"
Output: 10

*/

/*
Concept:
Substrings can be 'all prefixes of all suffix' OR 'all suffixes of all prefix'.
Therefore, for unique substrings, find:
	'all unique prefixes of all suffix'
	OR 'all unique suffixes of all prefix'.
*/

package Tries;

import Tries.Nodes.TrieNode;

public class CountUniqueSubstrings {
	public static int countNodes(TrieNode root) {
		if (root == null) {
			return 0;
		}
		
		int count = 0;
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				count += countNodes(root.children[i]);
			}
		}
		
		return count + 1;
	}
	
	public static int countUniqueSubstrings(String str) {
		Trie trie = new Trie();
		
		// Inserting all suffixes of the String
		for (int i = 0; i < str.length(); i++) {
			String suffix = str.substring(i);
			trie.insert(suffix);
		}
		
		// Counting all the nodes to count unique prefixes
		return countNodes(trie.root);
	}
	
	public static void main(String[] args) {
		String str = "ababa";
		
		System.out.println(countUniqueSubstrings(str));
	}
}
