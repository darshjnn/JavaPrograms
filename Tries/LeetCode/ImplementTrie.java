/*
208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure used to
efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and
spellchecker.

Implement the Trie class:
    Trie() Initializes the trie object.

    void insert(String word) Inserts the string word into the trie.

    boolean search(String word) Returns true if the string word is in the trie 
        (i.e., was inserted before), and false otherwise.
        
    boolean startsWith(String prefix) Returns true if there is a previously inserted
    string word that has the prefix, and false otherwise.
 

Example 1:
Input:
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output:
[null, null, true, false, true, null, true]
Explanation:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

*/

package Tries.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

class TrieNode {
    TrieNode[] children;
    boolean eow; // end of word

    TrieNode() {
        this.children = new TrieNode[26];
        Arrays.fill(children, null);
        this.eow = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;

        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;

        int level = 0;

        while (level < prefix.length()) {
            int index = prefix.charAt(level) - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
            ++level;
        }

        return true;
    }
}

public class ImplementTrie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Trie trie = new Trie();

        while (true) {
            System.out.print("Enter 1 for Insert; 2 for search word; 3 to check prefix: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter words: ");
                String words = sc.nextLine().trim();

                for (String word : words.split(" ")) {
                    if (!word.isEmpty()) {
                        trie.insert(word);
                    }
                }

                System.out.println("Insertions Successful!");

            } else if (choice == 2) {
                System.out.print("Search for: ");
                String word = sc.next();
                System.out.println(trie.search(word));

            } else if (choice == 3) {
                System.out.print("Check prefix: ");
                String prefix = sc.next();
                System.out.println(trie.startsWith(prefix));

            } else {
                break;
            }
        }

        sc.close();
    }
}
