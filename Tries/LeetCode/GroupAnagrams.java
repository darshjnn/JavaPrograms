/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any
order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

*/

package Tries.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
	public static void insert(TrieNode root, String word) {
		// Sorting the word before inserting in Trie
		char[] sorted = word.toCharArray();
		Arrays.sort(sorted);
		
		for (char c : sorted) {
			int index = c - 'a';
			
			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}
			
			root = root.children[index];
		}
		
		root.words.add(word);
		root.eow = true;
	}
	
	public static void groupWords(TrieNode root, List<List<String>> words) {
		if (root == null) {
			return;
		}
		
		if (root.eow) {
			words.add(root.words);
			return;
		}
		
		for (int i = 0; i < root.children.length; i++) {
			groupWords(root.children[i], words);
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		
		// Initializing Trie
		TrieNode root = new TrieNode();
		for (String str : strs) {
			insert(root, str);
		}
		
		// Finding Anagrams and grouping them
		List<List<String>> result = new ArrayList<>();
		groupWords(root, result);
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> result = groupAnagrams(strs);
		
		for (List<String> list : result) {
			System.out.println(list);
		}
	}
	
	public static class TrieNode {
		TrieNode[] children;
		boolean eow;
		ArrayList<String> words;
		
		TrieNode() {
			this.children = new TrieNode[26];
			Arrays.fill(this.children, null);
			this.eow = false;
			this.words = new ArrayList<>();
		}
	}
}
