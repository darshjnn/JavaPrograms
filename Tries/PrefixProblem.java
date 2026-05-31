/*
Prefix Problem
Find the shortest unique prefix for every word in a given list.
Assume no word is prefix of another.

Example:
arr[] = {"zebra", "dog", "duck", "dove"}
ans[] = {"z", "dog", "du", "dov"}

*/

package Tries;

import java.util.ArrayList;
import java.util.Arrays;

import Tries.Nodes.TrieNode;

public class PrefixProblem {
	public static void prefix(TrieNode root, String prefix, ArrayList<String> prefixes) {
		if (root == null) {
			return;
		}
		
		if (root.frequency == 1) {
			prefixes.add(prefix);
			return;
		}
		
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				prefix(root.children[i], prefix + (char) ('a' + i), prefixes);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"zebra", "dog", "duck", "dove"};
		Trie trie = new Trie();
		
		System.out.println(Arrays.toString(words));
		
		for (String word : words) {
			trie.insert(word);
		}
		
		ArrayList<String> prefixes = new ArrayList<>();
		prefix(trie.root, "", prefixes);
		System.out.println(prefixes);
	}
}
