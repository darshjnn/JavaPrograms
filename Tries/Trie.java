/*
Tries are also known as 'Retrieval Trees'.

Insertion Time Complexity: O(L), where L = length of largest word

*/

package Tries;

import Tries.Nodes.TrieNode;

public class Trie {
	public TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	// Insertion in Trie
	public void insert(String word) {
		TrieNode curr = this.root;
		
		for (int level = 0; level < word.length(); level++) {
			int index = word.charAt(level) - 'a';
			
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			
			++curr.children[index].frequency;
			curr = curr.children[index];
		}
		
		curr.eow = true;
	}
	
	// Traverse the Trie for a string to check if it exists or not
	// It will return boolean[]. boolean[0] = if prefix exists; boolean[1] = end of word value.
	private boolean[] traverse(TrieNode curr, String word) {
		for (int level = 0; level < word.length(); level++) {
			int index = word.charAt(level) - 'a';
			
			if (curr.children[index] == null) {
				return new boolean[]{false, false};
			}
			
			curr = curr.children[index];
		}
		
		return new boolean[]{true, curr.eow};
	}
	
	// Searching in Trie
	public boolean search(String word) {
		TrieNode curr = this.root;
		
		return traverse(curr, word)[1];
	}
	
	// Check if the prefix exists or not
	public boolean startsWith(String prefix) {
		TrieNode curr = this.root;
		
		return traverse(curr, prefix)[0];
	}
}
