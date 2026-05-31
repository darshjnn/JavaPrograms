package Tries.Nodes;

import java.util.Arrays;

public class TrieNode {
	public TrieNode[] children;
	public boolean eow; // End of word
	public int frequency;
	
	public TrieNode() {
		this.children = new TrieNode[26];
		Arrays.fill(children, null);
		this.eow = false;
		this.frequency = 1;
	}
}
