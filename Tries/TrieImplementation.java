package Tries;

import java.util.Arrays;
import java.util.Scanner;

public class TrieImplementation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Trie trie = new Trie();
		String[] words = {"the", "a", "there", "their",  "any", "thee"};
		System.out.println(Arrays.toString(words) + "\n");
		
		// Inserting in Trie
		for (String word : words) {
			trie.insert(word);
		}
		
		// Searching the word
		System.out.print("Enter string to search: ");
		String str = sc.nextLine();
		System.out.println("Is " + str + " present?: " + trie.search(str));
		
		// Check if the prefix exists
		System.out.print("Enter prefix to search: ");
		String prefix = sc.nextLine();
		System.out.println("Is " + prefix + " present?: " + trie.startsWith(prefix));

		sc.close();
	}
}
