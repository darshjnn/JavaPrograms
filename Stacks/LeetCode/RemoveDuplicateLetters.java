/*
316. Remove Duplicate Letters

Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible
results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

*/

package Stacks.LeetCode;

import java.util.*;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && i < map.get(stack.peek())) {
                    set.remove(stack.pop());
                }

                stack.push(c);
                set.add(c);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicateLetters(str));
    }
}

/*
Optimised Approach:

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] count = new int[26]; // To count the occurrences of each character
        boolean[] inResult = new boolean[26]; // To track if a character is already in the
        result
        
        // Count the occurrences of each character
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']--;  // Decrease the count of the current character
            
            // If the character is already in the result, skip it
            if (inResult[c - 'a']) {
                continue;
            }
            
            // Remove characters from the result if they are lexicographically larger
            // and still appear later in the string
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.
                    length() - 1) - 'a'] > 0) {
                inResult[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            // Add the current character to the result
            sb.append(c);
            inResult[c - 'a'] = true;
        }
        
        return sb.toString();
    }

 */